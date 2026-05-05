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

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private LocalizacionService localizacionService;
    
    @Autowired
    private ClienteMapper mapper;


    public ClienteDTO add(ClienteCreacionDTO dto) {
        Cliente nuevo;
        if(dto.getIdMunicipio() == null || (
            !localizacionService.municipioExistsById(dto.getIdMunicipio()) && 
            dto.getMunicipioCreacion() != null
        )){
            localizacionService.add_municipio(dto.getMunicipioCreacion());
        } else 
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Datos de municipio invalidos"
        );
        nuevo = mapper.toNewEntity(dto);
        nuevo.setMunicipio(localizacionService.getById(dto.getIdMunicipio()));
        clienteRepository.save(nuevo);
        return mapper.toDTO(nuevo);
    }

    public List<ClienteDTO> listar() {
        return clienteRepository.findAll().stream().map(
            (Cliente c) -> mapper.toDTO(c)).toList();
    }

    public ClienteDTO getAsDto(String id){
        return mapper.toDTO(getById(id));
    }

    public ClienteDTO update(String id, ClienteDTO dto){
        Cliente usuario = getById(id);
        Cliente actualizado = mapper.updateEntity(dto, usuario);
        Cliente guardado = clienteRepository.save(actualizado);
        return mapper.toDTO(guardado);
    }

    public void delete(String id){
        getById(id); // si no da error aqui, pues...
        clienteRepository.deleteById(id);
    }

    public Cliente getById(String id){
        return clienteRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "No se ha encontrado el cliente con id" + id
            ));
    }

    public boolean existsById(String id){
        return clienteRepository.existsById(id);
    }
}
