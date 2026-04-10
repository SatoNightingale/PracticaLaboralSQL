package com.satoshihans.practicalaboralsql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.models.dto.ClienteCreacionDTO;
import com.satoshihans.practicalaboralsql.models.dto.ClienteDTO;
import com.satoshihans.practicalaboralsql.models.entity.Cliente;
import com.satoshihans.practicalaboralsql.models.mappers.AdvanceMapper;
import com.satoshihans.practicalaboralsql.repositories.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MunicipioService municipioService;
    
    @Autowired
    private AdvanceMapper mapper;


    public List<ClienteDTO> listar_clientes() {
        return clienteRepository.findAll().stream().map(
            (Cliente c) -> mapper.toDTO(c)).toList();
    }

    public ClienteDTO add_cliente(ClienteCreacionDTO dto) {
        Cliente nuevo = mapper.toNewEntity(dto, municipioService);
        // Cliente nuevo = new Cliente();
        // nuevo.setNombre(dto.getNombre());
        // nuevo.setDireccion(dto.getDireccion());
        // nuevo.setGmail(dto.getGmail());
        // nuevo.setTelefono(dto.getTelefono());
        // if(municipioService.existsById(dto.getId_municipio())){
        //     Municipio municipio = municipioService.getById(dto.getId_municipio());
        //     nuevo.setMunicipio(municipio);
        // } else
        //     throw new RuntimeException("No existe el municipio con id " + dto.getId_municipio());

        clienteRepository.save(nuevo);
        return mapper.toDTO(nuevo);
    }

    public Cliente getById(Long id){
        return clienteRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "No se ha encontrado la entidad con id" + id
            ));
    }

    public boolean existsById(Long id){
        return clienteRepository.existsById(id);
    }
}
