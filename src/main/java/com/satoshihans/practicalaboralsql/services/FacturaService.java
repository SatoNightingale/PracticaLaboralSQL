package com.satoshihans.practicalaboralsql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.models.dto.FacturaDTO;
import com.satoshihans.practicalaboralsql.models.entity.Factura;
import com.satoshihans.practicalaboralsql.models.mappers.AdvanceMapper;
import com.satoshihans.practicalaboralsql.repositories.FacturaRepository;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    private AdvanceMapper mapper;


    public List<FacturaDTO> listar_facturas() {
        return facturaRepository.findAll().stream().map(
            (Factura f) -> mapper.toDTO(f)).toList();
    }

    public FacturaDTO add_Factura(FacturaDTO dto) {
        Factura nuevo = mapper.toEntity(dto, clienteService);
        // Factura nuevo = new Factura();
        // nuevo.setFecha(dto.getFecha());
        // nuevo.setImporte(dto.getImporte());
        // nuevo.setCliente(clienteService.getById(dto.getId_cliente()));
        facturaRepository.save(nuevo);
        return dto;
    }

    public Factura getById(Long id){
        return facturaRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "No se encontro la factura con id: " + id
            ));
    }
}
