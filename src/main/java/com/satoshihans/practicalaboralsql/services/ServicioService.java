package com.satoshihans.practicalaboralsql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.models.dto.ServicioDTO;
import com.satoshihans.practicalaboralsql.models.entity.Servicio;
import com.satoshihans.practicalaboralsql.models.mappers.ServicioMapper;
import com.satoshihans.practicalaboralsql.repositories.ServicioRepository;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;
    
    @Autowired
    private ServicioMapper mapper;


    public List<ServicioDTO> listar_clientes() {
        return servicioRepository.findAll().stream().map(
            (Servicio c) -> mapper.toDTO(c)).toList();
    }

    public Servicio add_servicio(ServicioDTO dto) {
        Servicio nuevo = mapper.toEntity(dto);
        servicioRepository.save(nuevo);
        return nuevo;
    }

    public Servicio getById(Long id){
        return servicioRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
