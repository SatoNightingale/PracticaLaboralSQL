package com.satoshihans.practicalaboralsql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.models.dto.MunicipioCreacionDTO;
import com.satoshihans.practicalaboralsql.models.dto.MunicipioDTO;
import com.satoshihans.practicalaboralsql.models.entity.Municipio;
import com.satoshihans.practicalaboralsql.models.mappers.LocalizacionMapper;
import com.satoshihans.practicalaboralsql.repositories.MunicipioRepository;
import com.satoshihans.practicalaboralsql.repositories.ProvinciaRepository;

@Service
public class MunicipioService {

    @Autowired
    private MunicipioRepository municipioRepository;

    @Autowired
    private ProvinciaRepository provinciaRepo;

    @Autowired
    private LocalizacionMapper mapper;

    public MunicipioDTO add_municipio(MunicipioCreacionDTO dto) {
        Municipio nuevo = mapper.toEntity(dto, provinciaRepo);
        Municipio guardado = municipioRepository.save(nuevo);
        return mapper.toDTO(guardado);
    }

    public List<MunicipioDTO> listar_municipios() {
        return municipioRepository.findAll().stream().map(
            (Municipio m) -> mapper.toDTO(m)).toList();
    }

    public Municipio getById(Long id){
        return municipioRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "No existe el municipio con id" + id
            ));
    }

    public boolean existsById(Long id){
        return municipioRepository.existsById(id);
    }
}
