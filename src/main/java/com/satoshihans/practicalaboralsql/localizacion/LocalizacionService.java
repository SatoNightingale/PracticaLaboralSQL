package com.satoshihans.practicalaboralsql.localizacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

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

        if(dto.getIdProvincia() != null && provinciaRepository.existsById(dto.getIdProvincia())){
            nuevo.setProvincia(provinciaRepository.findById(dto.getIdProvincia()).orElseThrow());
        } else if(dto.getNombreProvincia() != null) {
            Provincia provincia = add_provincia_noDto(dto.getNombreProvincia());
            nuevo.setProvincia(provincia);
        } else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Datos de provincia invalidos");

        Municipio guardado = municipioRepository.save(nuevo);
        return mapper.toDTO(guardado);
    }

    public ProvinciaDTO add_provincia(@RequestBody String nombre) {
        return mapper.toDTO(add_provincia_noDto(nombre));
    }

    public Provincia add_provincia_noDto(@RequestBody String nombre) {
        Provincia nuevo = new Provincia();
        nuevo.setNombre(nombre);
        Provincia guardado = provinciaRepository.save(nuevo);
        return guardado;
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
