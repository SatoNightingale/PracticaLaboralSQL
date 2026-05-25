package com.satoshihans.practicalaboralsql.lineaservicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.asignacion.*;
import com.satoshihans.practicalaboralsql.asignacion.dto.AdministraCreacionDTO;
import com.satoshihans.practicalaboralsql.asignacion.dto.AdministraCreacionDesdeLineaDeServiciosDTO;
import com.satoshihans.practicalaboralsql.asignacion.dto.TrabajaCreacionDTO;
import com.satoshihans.practicalaboralsql.asignacion.dto.TrabajaModificacionDTO;
import com.satoshihans.practicalaboralsql.especialista.*;
import com.satoshihans.practicalaboralsql.especialista.dto.EspecialistaAsignacionDTO;
import com.satoshihans.practicalaboralsql.especialista.dto.EspecialistaEliminarAsignacionDTO;
import com.satoshihans.practicalaboralsql.factura.Factura;
import com.satoshihans.practicalaboralsql.servicio.*;
import com.satoshihans.practicalaboralsql.usuario.*;

@Service
public class LineaDeServiciosService {

    @Autowired
    private LineaDeServiciosRepository lineaDeServiciosRepository;

    @Autowired
    private ServicioRepository servicioRepo;

    @Autowired
    private EspecialistaRepository especialistaRepo;

    @Autowired
    private TrabajaService trabajaService;

    @Autowired
    private AdministraService administraService;
    
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ServicioMapper mapper;


    @Transactional
    public LineaDeServicios addIndependiente(LineaDeServiciosCreacionDesdeFacturaDTO dto, Factura factura, Long idUsuarioAdmin) {
        LineaDeServicios nuevo = add(dto, factura, idUsuarioAdmin);
        LineaDeServicios guardado = lineaDeServiciosRepository.save(nuevo);
        return guardado;
    }

    public LineaDeServicios add(LineaDeServiciosCreacionDesdeFacturaDTO dto, Factura factura, Long idUsuarioAdmin){
        LineaDeServicios nuevo = new LineaDeServicios();

        Servicio servicio = servicioRepo.findById(dto.getIdServicio()).orElseThrow();
        List<Trabaja> contratos = new ArrayList<>();
        List<Administra> asignaciones = new ArrayList<>();
        Double importe = 0.0;

        for (TrabajaCreacionDTO trabajaDto : dto.getContratos()) {
            importe += trabajaDto.getImporte();
            contratos.add(trabajaService.add(trabajaDto, nuevo));
            asignaciones.add(administraService.add(
                new AdministraCreacionDesdeLineaDeServiciosDTO(
                    idUsuarioAdmin,
                    trabajaDto.getIdEspecialista()
                ), nuevo
            ));
        }
        
        nuevo.setFactura(factura);
        nuevo.setImporte(importe);
        nuevo.setServicio(servicio);
        nuevo.setContratados(contratos);
        nuevo.setAsignaciones(asignaciones);
        
        return nuevo;
    }

    public Double getImporteTotalFactura(Long id_factura){
        return lineaDeServiciosRepository.sumImporteByFacturaId(id_factura);
    }

    @Transactional
    public LineaDeServiciosDTO asignarEspecialista(EspecialistaAsignacionDTO dto, Long idLineaServicios){
        Usuario administrador = usuarioService.getAutenticado(dto.getIdUsuarioAdmin());
        LineaDeServicios lineaDeServicios = lineaDeServiciosRepository.findById(
            idLineaServicios).orElseThrow();
        // Validar que se este modificando una factura perteneciente a un periodo no cerrado
        if(!lineaDeServicios.getFactura().getPeriodo().isAbierto()){
            throw new ResponseStatusException(HttpStatus.LOCKED, "La linea de servicios que quiere modificar pertenece a un periodo cerrado");
        }
        Especialista especialista = especialistaRepo.findById(dto.getIdEspecialista())
            .orElseThrow();
        Optional<Trabaja> contrato = trabajaService.getByEspecialistaAndLineaServicios(
            dto.getIdEspecialista(), idLineaServicios);
        if(contrato.isPresent()){
            trabajaService.update(new TrabajaModificacionDTO(
                contrato.get().getId(),
                especialista.getId(),
                lineaDeServicios.getId(),
                dto.getImporte()
            ));
        } else {
            Trabaja nuevo_contrato = trabajaService.add(new TrabajaCreacionDTO(
                dto.getIdEspecialista(),
                dto.getImporte()
            ), lineaDeServicios);
            Administra nueva_asignacion = administraService.add(new AdministraCreacionDTO(
                administrador.getId(),
                especialista.getId(),
                lineaDeServicios.getId()
            ));
            lineaDeServicios.getAsignaciones().add(nueva_asignacion);
            lineaDeServicios.getContratados().add(nuevo_contrato);
        }

        LineaDeServicios guardado = lineaDeServiciosRepository.save(lineaDeServicios);
        
        return mapper.toDTO(guardado);
    }

    public List<LineaDeServiciosDTO> listar() {
        return lineaDeServiciosRepository.findAll().stream().map(
            (LineaDeServicios ls) -> mapper.toDTO(ls)).toList();
    }

    public LineaDeServicios getById(Long id){
        return lineaDeServiciosRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "No se ha encontrado la linea de servicios con id " + id
            ));
    }

    @Transactional
    public void eliminarAsignacion(EspecialistaEliminarAsignacionDTO dto, Long idLineaServicios){
        Usuario administrador = usuarioService.getAutenticado(dto.getIdUsuarioAdmin());
        LineaDeServicios lineaDeServicios = lineaDeServiciosRepository.findById(
            idLineaServicios).orElseThrow();
        // Validar que se este modificando una factura perteneciente a un periodo no cerrado
        if(!lineaDeServicios.getFactura().getPeriodo().isAbierto()){
            throw new ResponseStatusException(HttpStatus.LOCKED, "La linea de servicios que quiere modificar pertenece a un periodo cerrado");
        }
        Especialista especialista = especialistaRepo.findById(dto.getIdEspecialista())
            .orElseThrow();
        Optional<Trabaja> contrato = trabajaService.getByEspecialistaAndLineaServicios(
            dto.getIdEspecialista(), idLineaServicios);
        contrato.ifPresentOrElse(
            (Trabaja t) -> {
                Administra a = administraService.getByIds(
                    administrador.getId(),
                    especialista.getId(),
                    idLineaServicios
                );
                trabajaService.delete(t);
                administraService.delete(a);
                // Eliminar entidades trabaja y administra de la linea de servicios
                lineaDeServicios.getContratados().remove(t);
                lineaDeServicios.getAsignaciones().remove(a);
                // Si despues de la operacion la linea quedo vacia, eliminala
                if(lineaDeServicios.getContratados().isEmpty()){
                    lineaDeServiciosRepository.delete(lineaDeServicios);
                }
            },
            () -> {
                throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "No se ha encontrado el especialista con id: " + dto.getIdEspecialista()
                );
            }
        );
    }

    public boolean validarLinea(Long idLineaServicios){
        LineaDeServicios lineaDeServicios = lineaDeServiciosRepository.findById(idLineaServicios).orElseThrow();
        Double importeTotal = trabajaService.sumImporteByLineaServiciosId(idLineaServicios);
        return importeTotal.compareTo(lineaDeServicios.getImporte()) <= 0;
    }
}
