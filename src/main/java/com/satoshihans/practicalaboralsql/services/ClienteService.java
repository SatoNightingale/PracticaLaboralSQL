package com.satoshihans.practicalaboralsql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.satoshihans.practicalaboralsql.dao.ClienteRepository;
import com.satoshihans.practicalaboralsql.models.dto.ClienteCreacionDTO;
import com.satoshihans.practicalaboralsql.models.dto.ClienteDTO;
import com.satoshihans.practicalaboralsql.models.entity.Cliente;
import com.satoshihans.practicalaboralsql.models.entity.Municipio;
import com.satoshihans.practicalaboralsql.models.mappers.AdvanceMapper;

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

    public Cliente add_cliente(@RequestBody ClienteCreacionDTO dto) {
        Cliente nuevo = new Cliente();
        nuevo.setNombre(dto.getNombre());
        nuevo.setDireccion(dto.getDireccion());
        nuevo.setGmail(dto.getGmail());
        nuevo.setTelefono(dto.getTelefono());
        if(municipioService.existsById(dto.getMunicipio().getId())){
            Municipio municipio = municipioService.getById(dto.getMunicipio().getId());
            nuevo.setMunicipio(municipio);
        } else
            throw new RuntimeException("No existe el municipio con id " + dto.getMunicipio().getId());

        clienteRepository.save(nuevo);
        return nuevo;
    }
}
