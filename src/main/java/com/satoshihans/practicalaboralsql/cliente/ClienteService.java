package com.satoshihans.practicalaboralsql.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.localizacion.LocalizacionService;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private LocalizacionService localizacionService;
    
    @Autowired
    private ClienteMapper mapper;


    public ClienteDTO add(ClienteCreacionDTO dto) {
        if(clienteRepository.existsById(dto.getId())){
            throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "Ya existe un cliente con ese id"
            );
        }
        Cliente nuevo;
        if(dto.getIdMunicipio() == null){
            if(dto.getMunicipioCreacion() != null){
                dto.setIdMunicipio(localizacionService.add_municipio(dto.getMunicipioCreacion()).getId());
            } else 
                throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Datos de municipio invalidos"
            );
        }
        nuevo = mapper.toNewEntity(dto, localizacionService.getMunicipioRepository());
        // nuevo.setMunicipio(localizacionService.getById(dto.getIdMunicipio()));
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
