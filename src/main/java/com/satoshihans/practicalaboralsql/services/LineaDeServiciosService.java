package com.satoshihans.practicalaboralsql.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.models.dto.*;
import com.satoshihans.practicalaboralsql.models.entity.*;
import com.satoshihans.practicalaboralsql.models.mappers.ServicioMapper;
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
    private ServicioMapper mapper;


    public LineaDeServicios add(LineaDeServiciosCreacionDTO dto, Factura factura, Long idUsuarioAdmin) {
        LineaDeServicios nuevo = new LineaDeServicios();

        Servicio servicio = servicioRepo.findById(dto.getId_servicio()).orElseThrow();
        List<Trabaja> contratos = new ArrayList<>();
        List<Administra> asignaciones = new ArrayList<>();
        Double importe = 0.0;

        for (TrabajaCreacionDTO trabajaDto : dto.getContratos()) {
            importe += trabajaDto.getImporte();
            contratos.add(trabajaService.add_nodto(trabajaDto, nuevo));
            asignaciones.add(administraService.add(
                new AdministraCreacionDTO(
                    idUsuarioAdmin,
                    trabajaDto.getId_especialista(),
                    null, // WARNING
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
