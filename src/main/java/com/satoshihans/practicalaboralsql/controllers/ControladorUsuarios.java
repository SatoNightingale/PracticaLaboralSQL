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

import com.satoshihans.practicalaboralsql.models.dto.UsuarioAutenticacionDTO;
import com.satoshihans.practicalaboralsql.models.dto.UsuarioCreacionDTO;
import com.satoshihans.practicalaboralsql.models.dto.UsuarioDTO;
import com.satoshihans.practicalaboralsql.services.UsuarioService;


@RestController
@RequestMapping("/api/usuarios")
public class ControladorUsuarios {

    @Autowired
    private UsuarioService usuariosService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UsuarioCreacionDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            usuariosService.add(dto)
        );
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            usuariosService.getAsDto(id)
        );
    }

    @GetMapping("/")
    public List<UsuarioDTO> list() {
        return usuariosService.listar();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UsuarioDTO dto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
            usuariosService.update(id, dto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        usuariosService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/autenticar")
    public ResponseEntity<?> autenticarUsuario(@RequestBody UsuarioAutenticacionDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(
            usuariosService.autenticar(dto)
        );
    }
    
}
