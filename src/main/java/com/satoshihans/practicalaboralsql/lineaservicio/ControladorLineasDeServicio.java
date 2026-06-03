package com.satoshihans.practicalaboralsql.lineaservicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.satoshihans.practicalaboralsql.autenticacion.UsuarioSecurity;
import com.satoshihans.practicalaboralsql.especialista.dto.EspecialistaAsignacionDTO;
import com.satoshihans.practicalaboralsql.factura.FacturaService;

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
    public ResponseEntity<?> add_linea(
        @AuthenticationPrincipal UsuarioSecurity usuarioAdmin,
        @RequestBody LineaDeServiciosCreacionDTO dto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            facturaService.add_LineaDeServicios(dto, usuarioAdmin.getId())
        );
    }

    @Operation(summary = "Asignar especialista", description = "Asignar un especialista a una linea de servicios determinada")
    @PutMapping("/{id}/asignar")
    public ResponseEntity<?> asignarEspecialista(
        @Parameter(description = "El id de la linea de servicios a asignar") @PathVariable("id") Long id,
        @AuthenticationPrincipal UsuarioSecurity usuarioAdmin,
        @RequestBody EspecialistaAsignacionDTO dto
    ){
        return ResponseEntity.status(HttpStatus.OK).body(
            lineaDeServiciosService.asignarEspecialista(dto, id, usuarioAdmin.getId())
        );
    }

    @Operation(summary = "Validar linea de servicios", description = "Verificar que la suma de los importes asignados a una linea de servicios no supere el importe total de la linea")
    @GetMapping("/{id}/validar")
    public ResponseEntity<?> validarLinea(@PathVariable("id") Long idLinea) {
        return ResponseEntity.status(HttpStatus.OK).body(
            lineaDeServiciosService.validarLinea(idLinea)
        );
    }

    @Operation(summary = "Eliminar una asignacion", description = "Deshacer la asignacion de un especialista a una linea de servicios")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAsignacion(
        @Parameter(description = "El id de la linea de servicios asignada") @PathVariable("id") Long id,
        @AuthenticationPrincipal UsuarioSecurity usuarioAdmin,
        @RequestParam Long idESpecialista
    ){
        lineaDeServiciosService.eliminarAsignacion(idESpecialista, id, usuarioAdmin.getId());
        return ResponseEntity.accepted().build();
    }
}
