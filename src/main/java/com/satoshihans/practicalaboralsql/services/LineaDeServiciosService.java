package com.satoshihans.practicalaboralsql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satoshihans.practicalaboralsql.models.dto.LineaDeServiciosDTO;
import com.satoshihans.practicalaboralsql.models.entity.LineaDeServicios;
import com.satoshihans.practicalaboralsql.models.mappers.AdvanceMapper;
import com.satoshihans.practicalaboralsql.repositories.LineaDeServiciosRepository;

@Service
public class LineaDeServiciosService {

    @Autowired
    private LineaDeServiciosRepository lineaDeServiciosRepository;
    
    @Autowired
    private FacturaService facturaService;

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private AdvanceMapper mapper;


    public List<LineaDeServiciosDTO> listar_facturas() {
        return lineaDeServiciosRepository.findAll().stream().map(
            (LineaDeServicios ls) -> mapper.toDTO(ls)).toList();
    }

    public LineaDeServicios add_LineaDeServicios(LineaDeServiciosDTO dto) {
        LineaDeServicios nuevo = mapper.toEntity(dto, facturaService, servicioService);
        // LineaDeServicios nuevo = new LineaDeServicios();
        // nuevo.setImporte(dto.getImporte());
        // nuevo.setFactura(facturaService.getById(dto.getId_factura()));
        // nuevo.setServicio(servicioService.getById(dto.getId_servicio()));
        // nuevo.setAdministrador(usuarioService.getById(dto.getId_administrador()));
        lineaDeServiciosRepository.save(nuevo);
        return nuevo;
    }
}
