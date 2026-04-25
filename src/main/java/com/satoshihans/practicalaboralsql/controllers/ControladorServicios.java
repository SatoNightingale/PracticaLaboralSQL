package com.satoshihans.practicalaboralsql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.satoshihans.practicalaboralsql.models.dto.*;
import com.satoshihans.practicalaboralsql.services.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Servicios", description = "Gestionar los servicios disponibles")
@RestController
@RequestMapping("/api/servicios")
public class ControladorServicios {

    @Autowired
    private ServicioService servicioService;

    @Operation(summary = "Crear un servicio")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ServicioCreacionDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            servicioService.add(dto)
        );
    }
    
    @Operation(summary = "Obtener los datos de un servicio por su id")
    @GetMapping("/{id}")
    public ResponseEntity<?> get(
        @Parameter(description = "El id del servicio a obtener") @PathVariable Long id
    ){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicioService.getAsDto(id)
        );
    }

    @Operation(summary = "Listar todos los servicios disponibles")
    @GetMapping("/")
    public List<ServicioDTO> list() {
        return servicioService.listar();
    }

    @Operation(summary = "Actualizar los datos de un servicio")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ServicioCreacionDTO dto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
            servicioService.update(id, dto)
        );
    }

    @Operation(summary = "Eliminar un servicio por su id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        servicioService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
