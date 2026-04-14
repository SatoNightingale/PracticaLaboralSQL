package com.satoshihans.practicalaboralsql.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.models.dto.*;
import com.satoshihans.practicalaboralsql.models.entity.*;
import com.satoshihans.practicalaboralsql.models.mappers.ServicioMapper;
import com.satoshihans.practicalaboralsql.repositories.EspecialistaRepository;
import com.satoshihans.practicalaboralsql.repositories.LineaDeServiciosRepository;
import com.satoshihans.practicalaboralsql.repositories.ServicioRepository;

@Service
public class LineaDeServiciosService {

    @Autowired
    private LineaDeServiciosRepository lineaDeServiciosRepository;

    @Autowired
    private ServicioRepository servicioRepo;

    @Autowired
    private TrabajaService trabajaService;

    @Autowired
    private AdministraService administraService;
    
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EspecialistaRepository especialistaRepo;

    @Autowired
    private ServicioMapper mapper;


    public LineaDeServicios add(LineaDeServiciosCreacionDesdeFacturaDTO dto, Factura factura, Long idUsuarioAdmin) {
        LineaDeServicios nuevo = new LineaDeServicios();

        Servicio servicio = servicioRepo.findById(dto.getId_servicio()).orElseThrow();
        List<Trabaja> contratos = new ArrayList<>();
        List<Administra> asignaciones = new ArrayList<>();
        Double importe = 0.0;

        for (TrabajaCreacionDTO trabajaDto : dto.getContratos()) {
            importe += trabajaDto.getImporte();
            contratos.add(trabajaService.add_nodto(trabajaDto, nuevo));
            asignaciones.add(administraService.add(
                new AdministraCreacionDesdeLineaDeServiciosDTO(
                    idUsuarioAdmin,
                    trabajaDto.getId_especialista(),
                    LocalDateTime.now()
                ), nuevo
            ));
        }
        
        nuevo.setFactura(factura);
        nuevo.setImporte(importe);
        nuevo.setServicio(servicio);
        nuevo.setContratados(contratos);
        nuevo.setAsignaciones(asignaciones);

        lineaDeServiciosRepository.save(nuevo);
        return nuevo;
    }

    public Double getImporteTotalFactura(Long id_factura){
        return lineaDeServiciosRepository.sumImporteByFacturaId(id_factura);
    }

    public LineaDeServiciosDTO asignarEspecialistaImporte(EspecialistaAsignacionDTO dto){
        Usuario administrador = usuarioService.getAutenticado(dto.getIdUsuarioAdmin());
        usuarioService.checkAutenticado(administrador.getId());
        LineaDeServicios lineaDeServicios = lineaDeServiciosRepository.findById(
            dto.getIdLineaServicio()).orElseThrow();
        Especialista especialista = especialistaRepo.findById(dto.getIdEspecialista())
            .orElseThrow();
        Optional<Trabaja> contrato = trabajaService.getByEspecialistaAndLineaServicios(
            dto.getIdEspecialista(), dto.getIdLineaServicio());
        if(contrato.isPresent()){
            trabajaService.update(new TrabajaModificacionDTO(
                contrato.get().getId(),
                especialista.getId(),
                lineaDeServicios.getId(),
                dto.getImporte()
            ));
        } else {
            Trabaja nuevo_contrato = trabajaService.add_nodto(new TrabajaCreacionDTO(
                dto.getIdEspecialista(),
                dto.getImporte()
            ), lineaDeServicios);
            lineaDeServicios.getContratados().add(nuevo_contrato);
        }
        Administra nueva_asignacion = administraService.add(new AdministraCreacionDTO(
            administrador.getId(),
            especialista.getId(),
            lineaDeServicios.getId(),
            LocalDateTime.now()
        ));
        lineaDeServicios.getAsignaciones().add(nueva_asignacion);
        lineaDeServiciosRepository.save(lineaDeServicios);
        // Ahora hay que recalcular el importe de la factura
        // Vendria bien usar lo que deepseek dijo de los eventos pa desacoplar
        // No se puede tener un FacturaService en LineaDeServicioService y un LineaDeServicioService en FacturaService
        return mapper.toDTO(lineaDeServicios);
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
}
