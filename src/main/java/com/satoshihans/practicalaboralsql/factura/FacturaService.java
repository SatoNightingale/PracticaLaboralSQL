package com.satoshihans.practicalaboralsql.factura;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.cliente.ClienteRepository;
import com.satoshihans.practicalaboralsql.lineaservicio.*;
import com.satoshihans.practicalaboralsql.periodo.PeriodoRepository;
import com.satoshihans.practicalaboralsql.usuario.UsuarioService;

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

    public FacturaDTO add(FacturaCreacionDTO dto) {
        usuarioService.checkAutenticado(dto.getIdUsuarioAdmin());
        Factura nuevo = mapper.toNewEntity(dto, clienteRepo, periodoRepo, lineaDeServiciosService);
        Factura guardado = facturaRepository.save(nuevo);
        return mapper.toDTO(guardado);
    }

    public LineaDeServiciosDTO add_LineaDeServicios(LineaDeServiciosCreacionDTO dto){
        usuarioService.checkAutenticado(dto.getIdUsuarioAdmin());
        Factura factura = facturaRepository.findById(dto.getIdFactura()).orElseThrow();
        // Validar que la factura modificada pertenezca a un periodo activo
        if(!factura.getPeriodo().isAbierto())
            throw new ResponseStatusException(HttpStatus.LOCKED, "La factura que quiere modificar pertenece a un periodo cerrado");
        LineaDeServicios nuevo = lineaDeServiciosService.add(
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
        return importeTotal == factura.getImporteTotal();
    }
}
