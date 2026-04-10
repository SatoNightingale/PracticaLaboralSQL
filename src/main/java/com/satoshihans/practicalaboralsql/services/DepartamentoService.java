package com.satoshihans.practicalaboralsql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.models.dto.DepartamentoCreacionDTO;
import com.satoshihans.practicalaboralsql.models.dto.DepartamentoDTO;
import com.satoshihans.practicalaboralsql.models.entity.Departamento;
import com.satoshihans.practicalaboralsql.models.mappers.AdvanceMapper;
import com.satoshihans.practicalaboralsql.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private AdvanceMapper mapper;

    public Departamento add_departamento(DepartamentoCreacionDTO dto) {
        Departamento nuevo = mapper.toNewEntity(dto);
        departamentoRepository.save(nuevo);
        return nuevo;
    }

    public List<DepartamentoDTO> listar_departamentos() {
        return departamentoRepository.findAll().stream().map(
            (Departamento u) -> mapper.toDTO(u)).toList();
    }

    public Departamento getById(Long id){
        return departamentoRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public boolean existsById(Long id){
        return departamentoRepository.existsById(id);
    }
}
