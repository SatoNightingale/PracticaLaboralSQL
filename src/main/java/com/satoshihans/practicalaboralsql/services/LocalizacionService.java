package com.satoshihans.practicalaboralsql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.models.dto.MunicipioCreacionDTO;
import com.satoshihans.practicalaboralsql.models.dto.MunicipioDTO;
import com.satoshihans.practicalaboralsql.models.dto.ProvinciaDTO;
import com.satoshihans.practicalaboralsql.models.entity.Municipio;
import com.satoshihans.practicalaboralsql.models.entity.Provincia;
import com.satoshihans.practicalaboralsql.models.mappers.LocalizacionMapper;
import com.satoshihans.practicalaboralsql.repositories.MunicipioRepository;
import com.satoshihans.practicalaboralsql.repositories.ProvinciaRepository;

@Service
public class LocalizacionService {

    @Autowired
    private MunicipioRepository municipioRepository;

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Autowired
    private LocalizacionMapper mapper;

    public MunicipioDTO add_municipio(MunicipioCreacionDTO dto) {
        Municipio nuevo = mapper.toNewEntity(dto);

        if(dto.getIdProvincia() == null || (
            !provinciaRepository.existsById(dto.getIdProvincia()) &&
            dto.getNombreProvincia() != null
        )){
            add_provincia(dto.getNombreProvincia());
        } else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Datos de provincia invalidos");

        Municipio guardado = municipioRepository.save(nuevo);
        return mapper.toDTO(guardado);
    }

    public ProvinciaDTO add_provincia(@RequestBody String nombre) {
        Provincia nuevo = new Provincia();
        nuevo.setNombre(nombre);
        provinciaRepository.save(nuevo);
        return mapper.toDTO(nuevo);
    }

    public List<MunicipioDTO> listar_municipios() {
        return municipioRepository.findAll().stream().map(
            (Municipio m) -> mapper.toDTO(m)).toList();
    }

    public List<ProvinciaDTO> listar_provincias() {
        return provinciaRepository.findAll().stream().map(
            (Provincia p) -> mapper.toDTO(p)).toList();
    }

    public Municipio getById(Long id){
        return municipioRepository.findById(id).orElseThrow();
    }

    public boolean provinciaExistsById(Long id){
        return provinciaRepository.existsById(id);
    }

    public boolean municipioExistsById(Long id){
        return municipioRepository.existsById(id);
    }
}
