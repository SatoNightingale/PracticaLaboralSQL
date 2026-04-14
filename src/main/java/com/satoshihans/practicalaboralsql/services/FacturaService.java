package com.satoshihans.practicalaboralsql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.models.dto.FacturaCreacionDTO;
import com.satoshihans.practicalaboralsql.models.dto.FacturaDTO;
import com.satoshihans.practicalaboralsql.models.entity.Factura;
import com.satoshihans.practicalaboralsql.models.mappers.FacturaMapper;
import com.satoshihans.practicalaboralsql.repositories.ClienteRepository;
import com.satoshihans.practicalaboralsql.repositories.FacturaRepository;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ClienteRepository clienteRepo;
    
    @Autowired
    private LineaDeServiciosService lineaDeServiciosService;

    @Autowired
    private FacturaMapper mapper;

    public FacturaDTO add(FacturaCreacionDTO dto) {
        Factura nuevo = mapper.toNewEntity(dto, clienteRepo, lineaDeServiciosService);
        Factura guardado = facturaRepository.save(nuevo);
        return mapper.toDTO(guardado);
    }

    public List<FacturaDTO> listar() {
        return facturaRepository.findAll().stream().map(
            (Factura f) -> mapper.toDTO(f)).toList();
    }

    public FacturaDTO getAsDto(Long id){
        return mapper.toDTO(getById(id));
    }

    public Factura getById(Long id){
        return facturaRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "No se encontro la factura con id: " + id
            ));
    }
}
