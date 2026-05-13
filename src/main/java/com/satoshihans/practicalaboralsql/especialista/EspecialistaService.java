package com.satoshihans.practicalaboralsql.especialista;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.departamento.Departamento;
import com.satoshihans.practicalaboralsql.departamento.DepartamentoService;
import com.satoshihans.practicalaboralsql.especialista.dto.EspecialistaCreacionDTO;
import com.satoshihans.practicalaboralsql.especialista.dto.EspecialistaDTO;
import com.satoshihans.practicalaboralsql.especialista.dto.EspecialistaModificacionDTO;
import com.satoshihans.practicalaboralsql.especialista.dto.EspecialistaNombreDTO;

@Service
public class EspecialistaService {

    @Autowired
    private EspecialistaRepository especialistaRepository;

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private EspecialistaMapper mapper;

    public EspecialistaDTO add(EspecialistaCreacionDTO dto){
        Especialista nuevo = mapper.toNewEntity(dto, departamentoService);
        Especialista guardado = especialistaRepository.save(nuevo);
        return mapper.toDTO(guardado);
    }

    public List<EspecialistaDTO> list() {
        return especialistaRepository
            .findAll()
            .stream()
            .map((Especialista c) -> mapper.toDTO(c))
            .toList();
    }

    public List<EspecialistaNombreDTO> list_nombres() {
        return especialistaRepository.findAll().stream().map(
            (Especialista c) -> mapper.toNombreDTO(c)).toList();
    }

    public EspecialistaDTO getAsDto(Long id){
        return mapper.toDTO(getById(id));
    }

    public EspecialistaDTO update(Long id, EspecialistaModificacionDTO dto){
        Especialista especialista = getById(id);
        Especialista actualizado = mapper.updateEntity(dto, especialista);
        Especialista guardado = especialistaRepository.save(actualizado);
        return mapper.toDTO(guardado);
    }

    public void delete(Long id){
        getById(id); // si no da error aqui, pues...
        especialistaRepository.deleteById(id);
    }

    public EspecialistaDTO cambiarDepartamento(Long idEspecialista, Long idNuevoDepartamento){
        Especialista especialista = getById(idEspecialista);
        Departamento departamento = departamentoService.getById(idNuevoDepartamento);
        especialista.setDepartamento(departamento);
        especialistaRepository.save(especialista);
        return mapper.toDTO(especialista);
    }

    public Especialista getById(Long id){
        return especialistaRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "No se ha encontrado el especialista con id " + id
            ));
    }
}
