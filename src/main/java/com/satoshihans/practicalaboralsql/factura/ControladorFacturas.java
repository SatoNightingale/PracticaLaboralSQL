package com.satoshihans.practicalaboralsql.factura;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Facturas", description = "Facturas registradas en el sistema")
@RestController
@RequestMapping("/api/facturas")
public class ControladorFacturas {

    @Autowired
    private FacturaService facturaService;

    @Operation(summary = "Agregar una nueva factura", description = "Se agregaran tambien, como parte de la factura, todas las lineas de servicio definidas en el cuerpo de la peticion")
    @PostMapping()
    public ResponseEntity<?> add_factura(@RequestBody FacturaCreacionDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            facturaService.add(dto)
        );
    }

    @Operation(summary = "Mostrar los datos de una factura segun su id")
    @GetMapping("/{id}")
    public ResponseEntity<?> mostrarFactura(@PathVariable Long idFactura) {
        return ResponseEntity.status(HttpStatus.OK).body(
            facturaService.getAsDto(idFactura)
        );
    }
    
    @Operation(summary = "Listar todas las facturas con sus lineas de servicio")
    @GetMapping()
    public List<FacturaDTO> list() {
        return facturaService.listar();
    }

    @Operation(summary = "Validar factura", description = "Validar que el importe total de todas las lineas de servicio de una factura sea igual al importe de la factura. Devuelve true si esta bien repartida y false si no lo esta")
    @GetMapping("/{id}/validar")
    public ResponseEntity<?> validarFactura(@PathVariable Long idFactura) {
        return ResponseEntity.status(HttpStatus.OK).body(
            facturaService.validarFactura(idFactura)
        );
    }
}
