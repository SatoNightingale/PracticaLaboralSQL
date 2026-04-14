package com.satoshihans.practicalaboralsql.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satoshihans.practicalaboralsql.models.dto.FacturaCreacionDTO;
import com.satoshihans.practicalaboralsql.models.dto.LineaDeServiciosCreacionDTO;
import com.satoshihans.practicalaboralsql.services.FacturaService;
import com.satoshihans.practicalaboralsql.services.LineaDeServiciosService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/servicios")
public class ControladorServicios {

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private LineaDeServiciosService lineaDeServiciosService;

    @PostMapping("/factura")
    public ResponseEntity<?> add_factura(@RequestBody FacturaCreacionDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            facturaService.add(dto)
        );
    }
    
    @PostMapping("/linea")
    public ResponseEntity<?> add_linea(@RequestBody LineaDeServiciosCreacionDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            facturaService.add_LineaDeServicios(dto)
        );
    }
    
}
