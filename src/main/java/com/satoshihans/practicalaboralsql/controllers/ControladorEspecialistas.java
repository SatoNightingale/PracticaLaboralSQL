package com.satoshihans.practicalaboralsql.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satoshihans.practicalaboralsql.models.dto.EspecialistaCreacionDTO;
import com.satoshihans.practicalaboralsql.models.dto.EspecialistaModificacionDTO;
import com.satoshihans.practicalaboralsql.services.EspecialistaService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/especialistas")
public class ControladorEspecialistas {

    @Autowired
    private EspecialistaService especialistaService;

    @GetMapping
    public ResponseEntity<?> listar_especialistas() {
        return ResponseEntity.status(HttpStatus.OK).body(
            especialistaService.list()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get_especialista(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            especialistaService.getAsDto(id)
        );
    }

    @PostMapping
    public ResponseEntity<?> add_especialista(@RequestBody EspecialistaCreacionDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            especialistaService.add(dto)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEspecialista(@PathVariable Long id, @RequestBody EspecialistaModificacionDTO dto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
            especialistaService.update(id, dto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEspecialista(@PathVariable Long id){
        especialistaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/cambiar_depto")
    public ResponseEntity<?> cambiarDepartamento(@PathVariable Long id, @RequestBody Long idNuevoDepto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
            especialistaService.cambiarDepartamento(id, idNuevoDepto)
        );
    }
}
