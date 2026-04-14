package com.satoshihans.practicalaboralsql.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satoshihans.practicalaboralsql.services.*;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class Controller1 {

    @Autowired
    private DepartamentoService departamentoService;

    /* Departamentos */
    @GetMapping("/departamento")
    public ResponseEntity<?> listar_departamentos() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
            departamentoService.listar_departamentos()
        );
    }
    
}
