package com.satoshihans.practicalaboralsql.factura;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.cliente.ClienteRepository;
import com.satoshihans.practicalaboralsql.lineaservicio.*;
import com.satoshihans.practicalaboralsql.periodo.Periodo;
import com.satoshihans.practicalaboralsql.periodo.PeriodoRepository;

import jakarta.transaction.Transactional;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ClienteRepository clienteRepo;

    @Autowired
    private PeriodoRepository  periodoRepo;

    @Autowired
    private LineaDeServiciosRepository  lineaDeServiciosRepo;

    @Autowired
    private LineaDeServiciosService lineaDeServiciosService;

    @Autowired
    private FacturaMapper mapper;

    @Autowired
    private ServicioMapper servicioMapper;

    @Transactional
    public FacturaDTO add(FacturaCreacionDTO dto, Long idUsuarioAdmin) {
        Factura nuevo = mapper.toNewEntity(dto, clienteRepo);
        List<LineaDeServicios> lineasdeServicio = new ArrayList<>();
        Double importe = 0.0;

        if(dto.getLineasDeServicios().size() == 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
        "La factura debe crearse con al menos una linea de servicios");

        for (LineaDeServiciosCreacionDesdeFacturaDTO lineaServiciosDTO : dto.getLineasDeServicios()) {
            LineaDeServicios nuevaLineaServicios = lineaDeServiciosService.add(
                lineaServiciosDTO, nuevo, idUsuarioAdmin
            );
            importe += nuevaLineaServicios.getImporte();
            lineasdeServicio.add(nuevaLineaServicios);
        }

        nuevo.setLineasDeServicio(lineasdeServicio);
        nuevo.setImporteTotal(importe);

        Periodo periodoActual = periodoRepo.getPeriodoActual();

        if(periodoActual == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "No hay periodos en la base de datos a los que asignar la factura"
            );
        } else if(!periodoActual.isAbierto()){
            throw new ResponseStatusException(HttpStatus.LOCKED,
                "El periodo actual esta cerrado, no se pueden añadir facturas. Cree un nuevo periodo"
            );
        } else {
            nuevo.setPeriodo(periodoActual);
        }

        nuevo = facturaRepository.save(nuevo);
        
        return mapper.toDTO(nuevo);
    }

    public LineaDeServiciosDTO add_LineaDeServicios(LineaDeServiciosCreacionDTO dto, Long idUsuarioAdmin){
        Factura factura = facturaRepository.findById(dto.getIdFactura()).orElseThrow();
        // Validar que la factura modificada pertenezca a un periodo activo
        if(!factura.getPeriodo().isAbierto())
            throw new ResponseStatusException(
                HttpStatus.LOCKED,
                "La factura que quiere modificar pertenece a un periodo cerrado"
            );
        LineaDeServicios nuevo = lineaDeServiciosService.addIndependiente(
            mapper.toCreacionDesdeFacturaDTO(dto),
            factura,
            idUsuarioAdmin
        );
        factura.setImporteTotal(factura.getImporteTotal() + nuevo.getImporte());
        facturaRepository.save(factura);
        return servicioMapper.toDTO(nuevo);
    }

    // @EventListener
    // public void recalcularImporteFactura(FacturaModificadaEvent event){
    //     Factura factura = facturaRepository.findById(event.getIdFactura()).orElseThrow();
    //     factura.setImporteTotal(event.getImporteTotal());
    //     facturaRepository.save(factura);
    // }

    public List<FacturaDTO> listar() {
        return facturaRepository.findAll().stream().map(
            (Factura f) -> mapper.toDTO(f)).toList();
    }

    public FacturaDTO getAsDto(Long id){
        Factura f = getById(id);
        return mapper.toDTO(f);
    }

    public Factura getById(Long id){
        return facturaRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "No se encontro la factura con id: " + id
            ));
    }

    public boolean validarFactura(Long idFactura){
        facturaRepository.findById(idFactura).orElseThrow();
        boolean band = true;
        for(LineaDeServicios lds : lineaDeServiciosRepo.findAllByFacturaId(idFactura)){
            if(lds.getRepartido() != lds.getImporte()){
                band = false;
                break;
            }
        }
        return band;
    }

    private Double pendienteDeReparto(Factura factura){
        double pendiente = 0.0;
        for(LineaDeServicios lds : lineaDeServiciosRepo.findAllByFacturaId(factura.getId())){
            pendiente += lds.getImporte() - lds.getRepartido();
        }
        return pendiente;
    }

    public Double pendienteDeReparto(Long idFactura){
        Factura factura = facturaRepository.findById(idFactura).orElseThrow();
        return pendienteDeReparto(factura.getId());
    }

    public Double totalFacturadoGlobal(){
        return facturaRepository.totalFacturadoGlobal();
    }

    public List<FacturaDTO> mayorImportePendiente(){
        List<Factura> allFacturas = facturaRepository.findAll(); // lento
        return allFacturas.stream()
            .filter((Factura f) -> pendienteDeReparto(f) != 0.0)
            .sorted((Factura f1, Factura f2) -> 
                pendienteDeReparto(f2).compareTo(pendienteDeReparto(f1))
            )
            .map((Factura f) -> mapper.toDTO(f))
            .toList();
    }

    public List<FacturaDTO> masAntiguas(){
        List<Factura> allFacturas = facturaRepository.findAllByOrderByFechaEmisionDesc(); // lento
        return allFacturas.stream()
            .filter((Factura f) -> pendienteDeReparto(f) != 0.0)
            // .sorted((Factura f1, Factura f2) -> 
            //     f1.getFechaEmision().compareTo(f2.getFechaEmision())
            // )
            .map((Factura f) -> mapper.toDTO(f))
            .toList();
    }
}
