package com.satoshihans.practicalaboralsql.departamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.*;


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

    @Operation(summary = "Actualizar un departamento dado su id")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody DepartamentoCreacionDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(
            departamentoService.update(id, dto)
        );
    }

    @Operation(summary = "Listar todos los departamentos registrados")
    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(
            departamentoService.listar()
        );
    }
    
    @Operation(summary = "Eliminar un departamento por su id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        departamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
