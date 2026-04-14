package com.satoshihans.practicalaboralsql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.models.dto.ClienteCreacionDTO;
import com.satoshihans.practicalaboralsql.models.dto.ClienteDTO;
import com.satoshihans.practicalaboralsql.models.entity.Cliente;
import com.satoshihans.practicalaboralsql.models.mappers.ClienteMapper;
import com.satoshihans.practicalaboralsql.repositories.ClienteRepository;
import com.satoshihans.practicalaboralsql.repositories.MunicipioRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MunicipioRepository municipioRepo;
    
    @Autowired
    private ClienteMapper mapper;


    public ClienteDTO add(ClienteCreacionDTO dto) {
        Cliente nuevo = mapper.toNewEntity(dto, municipioRepo);
        clienteRepository.save(nuevo);
        return mapper.toDTO(nuevo);
    }

    public List<ClienteDTO> listar() {
        return clienteRepository.findAll().stream().map(
            (Cliente c) -> mapper.toDTO(c)).toList();
    }

    public ClienteDTO getAsDto(Long id){
        return mapper.toDTO(getById(id));
    }

    public ClienteDTO update(Long id, ClienteDTO dto){
        Cliente usuario = getById(id);
        Cliente actualizado = mapper.updateEntity(dto, usuario);
        Cliente guardado = clienteRepository.save(actualizado);
        return mapper.toDTO(guardado);
    }

    public void delete(Long id){
        getById(id); // si no da error aqui, pues...
        clienteRepository.deleteById(id);
    }

    public Cliente getById(Long id){
        return clienteRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "No se ha encontrado el cliente con id" + id
            ));
    }

    public boolean existsById(Long id){
        return clienteRepository.existsById(id);
    }
}
