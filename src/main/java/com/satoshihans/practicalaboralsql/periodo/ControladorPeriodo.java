package com.satoshihans.practicalaboralsql.periodo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.satoshihans.practicalaboralsql.periodo.dto.PeriodoCreacionDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;



@Tag(name = "Periodo", description = "Periodos de ingresos de la empresa")
@RestController
@RequestMapping("/api/periodos")
public class ControladorPeriodo {

	@Autowired
	private PeriodoService periodoService;

	@Operation(summary = "Añadir un nuevo periodo a la base de datos")
	@PostMapping()
    public ResponseEntity<?> add(@RequestBody PeriodoCreacionDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            periodoService.add(dto)
        );
    }

	@Operation(summary = "Mostrar los datos de un periodo dado su id")
    @GetMapping("/{id}")
    public ResponseEntity<?> mostrar(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            periodoService.getAsDto(id)
        );
    }

    @Operation(summary = "Obtener el periodo que estaba activo en una determinada fecha (no implementado aun)")
    @GetMapping("/fecha")
    public ResponseEntity<?> obtener_fecha(@RequestParam LocalDate fecha) {
        return ResponseEntity.status(HttpStatus.OK).body(
            periodoService.getPeriodoByFecha(fecha)
        );
    }
    
    @Operation(summary = "Listar todos los periodos")
    @GetMapping()
    public ResponseEntity<?> list() {
        return ResponseEntity.status(HttpStatus.OK).body(
            periodoService.listar()
        );
    }

    @Operation(summary = "Obtener evolucion histórica de los ingresos en cada período")
    @GetMapping("/historico")
    public ResponseEntity<?> ingresosHistoricos() {
        return ResponseEntity.status(HttpStatus.OK).body(
            periodoService.listaIngresosHistoricos()
        );
    }

	@Operation(summary = "Cerrar un periodo, bloqueando todas las asignaciones de facturas que tuvieron lugar en el")
	@PutMapping("/{id}/cerrar")
	public ResponseEntity<?> cerrarPeriodo(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(
			periodoService.cerrarPeriodo(id)
		);
	}
}
