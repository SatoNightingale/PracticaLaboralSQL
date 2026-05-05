package com.satoshihans.practicalaboralsql.controllers;

import com.satoshihans.practicalaboralsql.models.dto.ClienteCreacionDTO;
import com.satoshihans.practicalaboralsql.models.dto.ClienteDTO;
import com.satoshihans.practicalaboralsql.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Clientes", description = "Los clientes registrados en el sistema")
@RestController
@RequestMapping("/api/clientes")
public class ControladorClientes {

    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Agregar un cliente")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ClienteCreacionDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            clienteService.add(dto)
        );
    }

    @Operation(summary = "Obtener los datos de un cliente dado su id")
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            clienteService.getAsDto(id)
        );
    }

    @Operation(summary = "Listar todos los clientes")
    @GetMapping("/")
    public List<ClienteDTO> list() {
        return clienteService.listar();
    }

    @Operation(summary = "Actualizar los datos de un cliente")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(
        @PathVariable String id,
        @RequestBody ClienteDTO dto
    ) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
            clienteService.update(id, dto)
        );
    }

    @Operation(summary = "Eliminar un cliente por su id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
