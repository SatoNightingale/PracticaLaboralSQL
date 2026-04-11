package com.satoshihans.practicalaboralsql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satoshihans.practicalaboralsql.models.dto.*;
import com.satoshihans.practicalaboralsql.services.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/api")
public class Controller1 {

    

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private DepartamentoService departamentoService;

    
    /* Clientes */
    @PostMapping("/clientes")
    public ResponseEntity<?> add_cliente(@RequestBody ClienteCreacionDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            clienteService.add_cliente(dto)
        );
    }
    
    @GetMapping("/clientes")
    public List<ClienteDTO> listar_clientes() {
        return clienteService.listar_clientes();
    }

    /* Departamentos */
    @GetMapping("/departamento")
    public ResponseEntity<?> listar_departamentos() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
            departamentoService.listar_departamentos()
        );
    }

    
    
    
}
