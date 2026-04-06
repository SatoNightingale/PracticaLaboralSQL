package com.satoshihans.practicalaboralsql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satoshihans.practicalaboralsql.models.dto.*;
import com.satoshihans.practicalaboralsql.models.entity.*;
import com.satoshihans.practicalaboralsql.services.ClienteService;
import com.satoshihans.practicalaboralsql.services.UsuarioService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api")
public class Controller1 {

    @Autowired
    private UsuarioService usuariosService;

    @Autowired
    private ClienteService clienteService;


    @PostMapping("/add_usuario")
    public Usuario add_usuario(@RequestBody UsuarioDTO dto) {
        return usuariosService.add_usuario(dto);
    }
    
    @GetMapping("/usuarios")
    public List<UsuarioDTO> listar_usuarios() {
        return usuariosService.listar_usuarios();
    }
    
    @PostMapping("/add_cliente")
    public Cliente add_cliente(@RequestBody ClienteCreacionDTO dto) {
        return clienteService.add_cliente(dto);
    }
    
    @GetMapping("/clientes")
    public List<ClienteDTO> listar_clientes() {
        return clienteService.listar_clientes();
    }
}
