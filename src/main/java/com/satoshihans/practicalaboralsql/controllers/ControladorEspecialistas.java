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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Tag(name = "Especialista", description = "Especialistas que trabajan en la empresa")
@RestController
@RequestMapping("/api/especialistas")
public class ControladorEspecialistas {

    @Autowired
    private EspecialistaService especialistaService;

    @Operation(summary = "Listar todos los especialistas registrados")
    @GetMapping
    public ResponseEntity<?> listar_especialistas() {
        return ResponseEntity.status(HttpStatus.OK).body(
            especialistaService.list()
        );
    }

    @Operation(summary = "Obtener los datos de un especialista")
    @GetMapping("/{id}")
    public ResponseEntity<?> get_especialista(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            especialistaService.getAsDto(id)
        );
    }

    @Operation(summary = "Agregar un especialista")
    @PostMapping
    public ResponseEntity<?> add_especialista(@RequestBody EspecialistaCreacionDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            especialistaService.add(dto)
        );
    }

    @Operation(summary = "Actualizar los datos un especialista")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEspecialista(@PathVariable Long id, @RequestBody EspecialistaModificacionDTO dto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
            especialistaService.update(id, dto)
        );
    }

    @Operation(summary = "Eliminar un especialista por su id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEspecialista(@PathVariable Long id){
        especialistaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Cambiar un especialista de departamento")
    @PutMapping("/{id}/cambiar_depto")
    public ResponseEntity<?> cambiarDepartamento(
        @Parameter(description = "El id del especialista al que se le va a cambiar el departamento") @PathVariable Long id,
        @Parameter(description = "El id del nuevo departamento del especialista") @RequestBody Long idNuevoDepto
    ){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
            especialistaService.cambiarDepartamento(id, idNuevoDepto)
        );
    }
}
