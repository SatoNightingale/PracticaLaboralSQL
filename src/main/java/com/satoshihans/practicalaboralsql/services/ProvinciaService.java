package com.satoshihans.practicalaboralsql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.dao.ProvinciaRepository;
import com.satoshihans.practicalaboralsql.models.dto.ProvinciaDTO;
import com.satoshihans.practicalaboralsql.models.entity.Provincia;
import com.satoshihans.practicalaboralsql.models.mappers.AdvanceMapper;

@Service
public class ProvinciaService {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Autowired
    private AdvanceMapper mapper;

    public Provincia add_provincia(@RequestBody String nombre) {
        Provincia nuevo = new Provincia();
        nuevo.setNombre(nombre);
        provinciaRepository.save(nuevo);
        return nuevo;
    }

    public List<ProvinciaDTO> listar_provincias() {
        return provinciaRepository.findAll().stream().map(
            (Provincia p) -> mapper.toDTO(p)).toList();
    }

    public Provincia getById(Long id){
        return provinciaRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public boolean existsById(Long id){
        return provinciaRepository.existsById(id);
    }
}
