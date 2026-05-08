package com.satoshihans.practicalaboralsql.departamento;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.especialista.EspecialistaMapper;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private EspecialistaMapper mapper;

    public Departamento add_NoDto(DepartamentoCreacionDTO dto) {
        if (departamentoRepository.count() < 5) {
            Departamento nuevo = mapper.toNewEntity(dto);
            Departamento guardado = departamentoRepository.save(nuevo);
            return guardado;
        } else throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST,
            "No puede haber más de 5 departamentos activos"
        );
    }

    public DepartamentoDTO add(DepartamentoCreacionDTO dto) {
        return mapper.toDTO(add_NoDto(dto));
    }

    public List<DepartamentoDTO> listar() {
        return departamentoRepository
            .findAll()
            .stream()
            .map((Departamento u) -> mapper.toDTO(u))
            .toList();
    }

    public Departamento getById(Long id) {
        return departamentoRepository
            .findById(id)
            .orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND)
            );
    }

    public DepartamentoDTO update(Long id, DepartamentoCreacionDTO dto) {
        Departamento entity = getById(id);
        Departamento actualizado = mapper.updateEntity(dto, entity);
        Departamento guardado = departamentoRepository.save(actualizado);
        return mapper.toDTO(guardado);
    }

    public void delete(Long id) {
        getById(id);
        departamentoRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return departamentoRepository.existsById(id);
    }
}
