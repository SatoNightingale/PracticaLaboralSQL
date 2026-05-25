package com.satoshihans.practicalaboralsql.factura;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.cliente.ClienteRepository;
import com.satoshihans.practicalaboralsql.lineaservicio.*;
import com.satoshihans.practicalaboralsql.periodo.Periodo;
import com.satoshihans.practicalaboralsql.periodo.PeriodoRepository;
import com.satoshihans.practicalaboralsql.usuario.UsuarioService;

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
    private UsuarioService usuarioService;

    @Autowired
    private LineaDeServiciosService lineaDeServiciosService;

    @Autowired
    private FacturaMapper mapper;

    @Autowired
    private ServicioMapper servicioMapper;

    @Transactional
    public FacturaDTO add(FacturaCreacionDTO dto) {
        usuarioService.checkAutenticado(dto.getIdUsuarioAdmin());

        Factura nuevo = mapper.toNewEntity(dto, clienteRepo);
        List<LineaDeServicios> lineasdeServicio = new ArrayList<>();
        Double importe = 0.0;

        for (LineaDeServiciosCreacionDesdeFacturaDTO lineaServiciosDTO : dto.getLineasDeServicios()) {
            LineaDeServicios nuevaLineaServicios = lineaDeServiciosService.add(
                lineaServiciosDTO, nuevo, dto.getIdUsuarioAdmin()
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

    public LineaDeServiciosDTO add_LineaDeServicios(LineaDeServiciosCreacionDTO dto){
        usuarioService.checkAutenticado(dto.getIdUsuarioAdmin());
        Factura factura = facturaRepository.findById(dto.getIdFactura()).orElseThrow();
        // Validar que la factura modificada pertenezca a un periodo activo
        if(!factura.getPeriodo().isAbierto())
            throw new ResponseStatusException(HttpStatus.LOCKED, "La factura que quiere modificar pertenece a un periodo cerrado");
        LineaDeServicios nuevo = lineaDeServiciosService.addIndependiente(
            mapper.toCreacionDesdeFacturaDTO(dto), factura, dto.getIdUsuarioAdmin());
        // recalcularImporteFactura(factura);
        facturaRepository.save(factura);
        return servicioMapper.toDTO(nuevo);
    }

    // public void recalcularImporteFactura(Factura factura){
    //     factura.setImporteTotal(lineaDeServiciosService.getImporteTotalFactura(factura.getId()));
    // }

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
        return mapper.toDTO(getById(id));
    }

    public Factura getById(Long id){
        return facturaRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "No se encontro la factura con id: " + id
            ));
    }

    public boolean validarFactura(Long idFactura){
        Factura factura = facturaRepository.findById(idFactura).orElseThrow();
        Double importeTotal = lineaDeServiciosService.getImporteTotalFactura(idFactura);
        // Double (tipo wrapper) debe ser comparado con equals, justo como String
        // También se puede usar compareTo, to esta gente implementa Comparable
        return importeTotal.equals(factura.getImporteTotal());
    }
}
