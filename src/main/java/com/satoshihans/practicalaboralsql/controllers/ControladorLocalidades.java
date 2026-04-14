package com.satoshihans.practicalaboralsql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.satoshihans.practicalaboralsql.models.dto.*;
import com.satoshihans.practicalaboralsql.services.MunicipioService;
import com.satoshihans.practicalaboralsql.services.ProvinciaService;

@RestController
@RequestMapping("/api/localidades")
public class ControladorLocalidades {

    @Autowired
    private MunicipioService municipioService;

    @Autowired
    private ProvinciaService provinciaService;


    @PostMapping("/provincias")
    public ResponseEntity<?> add_provincia(@RequestBody String nombre) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            provinciaService.add_provincia(nombre)
        );
    }

    @PostMapping("/municipios")
    public ResponseEntity<?> add_municipio(@RequestBody MunicipioCreacionDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            municipioService.add_municipio(dto)
        );
    }

    @GetMapping("/provincias")
    public List<ProvinciaDTO> listar_provincias() {
        return provinciaService.listar_provincias();
    }

    @GetMapping("/municipios")
    public List<MunicipioDTO> listar_municipios() {
        return municipioService.listar_municipios();
    }
}
