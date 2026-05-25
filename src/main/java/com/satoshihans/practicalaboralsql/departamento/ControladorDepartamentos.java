package com.satoshihans.practicalaboralsql.departamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;


@Tag(name = "Departamentos", description = "Departamentos de la empresa")
@RestController
@RequestMapping("/api/departamento")
public class ControladorDepartamentos {

    @Autowired
    private DepartamentoService departamentoService;

    @Operation(summary = "Agregar un departamento")
    @PostMapping
    public ResponseEntity<?> add(@RequestBody DepartamentoCreacionDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            departamentoService.add(dto)
        );
    }

    @Operation(summary = "Listar todos los departamentos registrados")
    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(
            departamentoService.listar()
        );
    }

    @Operation(summary = "Obtener los datos de un departamento por su id")
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            departamentoService.getAsDTO(id)
        );
    }

    @Operation(summary = "Generar reporte de ingresos del departamento")
    @GetMapping("/{id}/reporte")
    public ResponseEntity<?> reporte(
        @Parameter(description = "ID del departamento", required = true)
        @PathVariable("id") Long idDepto,
        @Parameter(description = "ID del periodo", required = true)
        @RequestParam("idPeriodo") Long idPeriodo
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(
            departamentoService.reporteIngresosDepartamento(idDepto, idPeriodo)
        );
    }

    @Operation(summary = "Actualizar un departamento dado su id")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody DepartamentoCreacionDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(
            departamentoService.update(id, dto)
        );
    }
    
    @Operation(summary = "Eliminar un departamento por su id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        departamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
