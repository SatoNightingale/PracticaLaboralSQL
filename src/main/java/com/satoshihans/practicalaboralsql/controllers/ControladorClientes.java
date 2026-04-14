package com.satoshihans.practicalaboralsql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satoshihans.practicalaboralsql.models.dto.ClienteCreacionDTO;
import com.satoshihans.practicalaboralsql.models.dto.ClienteDTO;
import com.satoshihans.practicalaboralsql.services.ClienteService;


@RestController
@RequestMapping("/api/clientes")
public class ControladorClientes {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ClienteCreacionDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            clienteService.add(dto)
        );
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            clienteService.getAsDto(id)
        );
    }

    @GetMapping("/")
    public List<ClienteDTO> list() {
        return clienteService.listar();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ClienteDTO dto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
            clienteService.update(id, dto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
