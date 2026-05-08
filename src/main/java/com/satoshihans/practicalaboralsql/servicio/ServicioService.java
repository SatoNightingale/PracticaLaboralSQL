package com.satoshihans.practicalaboralsql.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satoshihans.practicalaboralsql.lineaservicio.ServicioMapper;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;
    
    @Autowired
    private ServicioMapper mapper;


    public Servicio add(ServicioCreacionDTO dto) {
        Servicio nuevo = mapper.toNewEntity(dto);
        servicioRepository.save(nuevo);
        return nuevo;
    }

    public List<ServicioDTO> listar() {
        return servicioRepository.findAll().stream().map(
            (Servicio c) -> mapper.toDTO(c)).toList();
    }

    public ServicioDTO getAsDto(Long id){
        return mapper.toDTO(servicioRepository.findById(id).orElseThrow());
    }
    
    public ServicioDTO update(Long id, ServicioCreacionDTO dto){
        Servicio servicio = servicioRepository.findById(id).orElseThrow();
        Servicio actualizado = mapper.updateEntity(dto, servicio);
        Servicio guardado = servicioRepository.save(actualizado);
        return mapper.toDTO(guardado);
    }

    public void delete(Long id){
        servicioRepository.deleteById(id);
    }

}
