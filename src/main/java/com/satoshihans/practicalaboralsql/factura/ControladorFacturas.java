package com.satoshihans.practicalaboralsql.factura;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.satoshihans.practicalaboralsql.autenticacion.UsuarioSecurity;

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
    public ResponseEntity<?> add_factura(
        @AuthenticationPrincipal UsuarioSecurity usuarioAdmin,
        @RequestBody FacturaCreacionDTO dto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            facturaService.add(dto, usuarioAdmin.getId())
        );
    }

    @Operation(summary = "Mostrar los datos de una factura segun su id")
    @GetMapping("/{id}")
    public ResponseEntity<?> mostrarFactura(@PathVariable("id") Long idFactura) {
        return ResponseEntity.status(HttpStatus.OK).body(
            facturaService.getAsDto(idFactura)
        );
    }
    
    @Operation(summary = "Listar todas las facturas con sus lineas de servicio")
    @GetMapping()
    public List<FacturaDTO> list() {
        return facturaService.listar();
    }

    @Operation(summary = "Validar factura",
        description = "Validar que la factura no tenga lineas de servicio que no esten completamente repartidas"
    )
    @GetMapping("/{id}/validar")
    public ResponseEntity<?> validarFactura(@PathVariable("id") Long idFactura) {
        return ResponseEntity.status(HttpStatus.OK).body(
            facturaService.validarFactura(idFactura)
        );
    }

    @Operation(summary = "Total facturado global", description = "Total recaudado en todas las facturas registradas en el sistema hasta la fecha, independientemente de que sus lineas de servicio esten completamente repartidas")
    @GetMapping("/total_facturado")
    public ResponseEntity<?> totalFacturadoGlobal() {
        return ResponseEntity.status(HttpStatus.OK).body(
            facturaService.totalFacturadoGlobal()
        );
    }

    @Operation(summary = "Facturas mas antiguas con importe pendiente")
    @GetMapping("/antiguas")
    public ResponseEntity<?> masAntiguas() {
        return ResponseEntity.status(HttpStatus.OK).body(
            facturaService.masAntiguas()
        );
    }

    @Operation(summary = "Facturas con mayor importe pendiente")
    @GetMapping("/importe_pendiente")
    public ResponseEntity<?> mayorImportePendiente() {
        return ResponseEntity.status(HttpStatus.OK).body(
            facturaService.mayorImportePendiente()
        );
    }
}
