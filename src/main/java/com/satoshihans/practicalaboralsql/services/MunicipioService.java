package com.satoshihans.practicalaboralsql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.dao.MunicipioRepository;
import com.satoshihans.practicalaboralsql.models.dto.MunicipioCreacionDTO;
import com.satoshihans.practicalaboralsql.models.dto.MunicipioDTO;
import com.satoshihans.practicalaboralsql.models.entity.Municipio;
import com.satoshihans.practicalaboralsql.models.entity.Provincia;
import com.satoshihans.practicalaboralsql.models.mappers.AdvanceMapper;

@Service
public class MunicipioService {

    @Autowired
    private MunicipioRepository municipioRepository;

    @Autowired
    private ProvinciaService provinciaService;

    @Autowired
    private AdvanceMapper mapper;

    public Municipio add_municipio(MunicipioCreacionDTO dto) {
        Municipio nuevo = new Municipio();
        nuevo.setNombre(dto.getNombre());
        Provincia provincia = null;
        
        if(dto.getId_provincia() != null && provinciaService.existsById(dto.getId_provincia())){
            provincia = provinciaService.getById(dto.getId_provincia());
        } else if (dto.getNombre_provincia() != null){
            provincia = provinciaService.add_provincia(dto.getNombre_provincia());
        } else {
            System.err.println("No existe la provincia con id " + dto.getId_provincia());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        nuevo.setProvincia(provincia);
        municipioRepository.save(nuevo);
        return nuevo;
    }

    public List<MunicipioDTO> listar_municipios() {
        return municipioRepository.findAll().stream().map(
            (Municipio m) -> mapper.toDTO(m)).toList();
    }

    public Municipio getById(Long id){
        return municipioRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public boolean existsById(Long id){
        return municipioRepository.existsById(id);
    }
}
