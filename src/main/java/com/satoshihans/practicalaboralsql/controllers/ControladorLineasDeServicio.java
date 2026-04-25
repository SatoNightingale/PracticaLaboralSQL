package com.satoshihans.practicalaboralsql.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.satoshihans.practicalaboralsql.models.dto.*;
import com.satoshihans.practicalaboralsql.services.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Linea de servicio", description = "Operaciones para gestionar lineas de servicio")
@RestController
@RequestMapping("/api/lineas")
public class ControladorLineasDeServicio {

    @Autowired
    private LineaDeServiciosService lineaDeServiciosService;

    @Autowired
    private FacturaService facturaService;

    @Operation(summary = "Agregar una linea de servicios")
    @PostMapping("/")
    public ResponseEntity<?> add_linea(@RequestBody LineaDeServiciosCreacionDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            facturaService.add_LineaDeServicios(dto)
        );
    }

    @Operation(summary = "Asignar especialista", description = "Asignar un especialista a una linea de servicios determinada")
    @PutMapping("/{id}/asignar")
    public ResponseEntity<?> asignarEspecialista(
        @Parameter(description = "El id de la linea de servicios a asignar") @PathVariable Long id,
        @RequestBody EspecialistaAsignacionDTO dto
    ){
        return ResponseEntity.status(HttpStatus.OK).body(
            lineaDeServiciosService.asignarEspecialista(dto, id)
        );
    }

    @Operation(summary = "Validar linea de servicios", description = "Verificar que la suma de los importes asignados a una linea de servicios no supere el importe total de la linea")
    @GetMapping("/{id}/validar")
    public ResponseEntity<?> validarLinea(@PathVariable Long idLinea) {
        return ResponseEntity.status(HttpStatus.OK).body(
            lineaDeServiciosService.validarLinea(idLinea)
        );
    }

    @Operation(summary = "Eliminar una asignacion", description = "Deshacer la asignacion de un especialista a una linea de servicios")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAsignacion(
        @Parameter(description = "El id de la linea de servicios asignada") @PathVariable Long id,
        @RequestBody EspecialistaEliminarAsignacionDTO dto
    ){
        lineaDeServiciosService.eliminarAsignacion(dto, id);
        return ResponseEntity.accepted().build();
    }
}
