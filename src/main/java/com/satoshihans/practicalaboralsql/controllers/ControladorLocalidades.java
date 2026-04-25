package com.satoshihans.practicalaboralsql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.satoshihans.practicalaboralsql.models.dto.*;
import com.satoshihans.practicalaboralsql.services.LocalizacionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Provincias y municipios", description = "Las provincias y municipios registrados en el sistema")
@RestController
@RequestMapping("/api/localidades")
public class ControladorLocalidades {


    @Autowired
    private LocalizacionService localizacionService;

    @Operation(summary = "Agregar una provincia")
    @PostMapping("/provincias")
    public ResponseEntity<?> add_provincia(@RequestBody String nombre) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            localizacionService.add_provincia(nombre)
        );
    }

    @Operation(summary = "Agregar un municipio")
    @PostMapping("/municipios")
    public ResponseEntity<?> add_municipio(@RequestBody MunicipioCreacionDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            localizacionService.add_municipio(dto)
        );
    }

    @Operation(summary = "Listar todas las un provincias")
    @GetMapping("/provincias")
    public List<ProvinciaDTO> listar_provincias() {
        return localizacionService.listar_provincias();
    }

    @Operation(summary = "Listar todos los municipios")
    @GetMapping("/municipios")
    public List<MunicipioDTO> listar_municipios() {
        return localizacionService.listar_municipios();
    }
}
