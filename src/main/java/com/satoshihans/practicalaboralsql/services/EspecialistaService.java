package com.satoshihans.practicalaboralsql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satoshihans.practicalaboralsql.models.entity.*;
import com.satoshihans.practicalaboralsql.models.mappers.AdvanceMapper;
import com.satoshihans.practicalaboralsql.models.mappers.EspecialistaMapper;
import com.satoshihans.practicalaboralsql.repositories.EspecialistaRepository;
import com.satoshihans.practicalaboralsql.models.dto.*;

@Service
public class EspecialistaService {

    @Autowired
    private EspecialistaRepository especialistaRepository;

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private EspecialistaMapper mapper;

    public List<EspecialistaDTO> list() {
        return especialistaRepository.findAll().stream().map(
            (Especialista c) -> mapper.toDTO(c)).toList();
    }

    public Especialista add(EspecialistaCreacionDTO dto){
        Especialista nuevo = mapper.toNewEntity(dto, departamentoService);
        // Especialista nuevo = new Especialista();
        // nuevo.setNombre(dto.getNombre());
        // nuevo.setEspecialidad(dto.getEspecialidad());
        
        // if(departamentoService.existsById(dto.getIdDepartamento())){
        //     Departamento departamento = departamentoService.getById(dto.getIdDepartamento());
        //     nuevo.setDepartamento(departamento);
        // } else 
        //     throw new RuntimeException("No existe el municipio con id " + dto.getIdDepartamento());
        
        especialistaRepository.save(nuevo);
        return nuevo;
    }
}
