package com.satoshihans.practicalaboralsql.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Usuarios", description = "Operaciones para gestionar usuarios")

@RestController
@RequestMapping("/api/usuarios")
public class ControladorUsuarios {

    @Autowired
    private UsuarioService usuariosService;

    @Operation(summary = "Agregar un usuario")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody UsuarioCreacionDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            usuariosService.add(dto)
        );
    }
    
    @Operation(summary = "Obtener un usuario por su id")
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            usuariosService.getAsDto(id)
        );
    }

    @Operation(summary = "Listar todos los usuarios del sistema")
    @GetMapping("/")
    public List<UsuarioDTO> list() {
        return usuariosService.listar();
    }

    @Operation(summary = "Actualizar los datos de un usuario")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(
        @Parameter(description = "El id del usuario a actualizar") @PathVariable("id") Long id, @RequestBody UsuarioDTO dto
    ){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
            usuariosService.update(id, dto)
        );
    }

    @Operation(summary = "Eliminar un usuario por su id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        usuariosService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Autenticar un usuario en el sistema")
    @PutMapping("/autenticar")
    public ResponseEntity<?> autenticarUsuario(@RequestBody UsuarioAutenticacionDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(
            usuariosService.autenticar(dto)
        );
    }

    @Operation(summary = "Desautenticar un usuario")
    @PutMapping("/desautenticar")
    public ResponseEntity<Void> autenticarUsuario(@RequestParam Long usuario_id) {
        usuariosService.desautenticar(usuario_id);
        return ResponseEntity.accepted().build();
    }
    
}
