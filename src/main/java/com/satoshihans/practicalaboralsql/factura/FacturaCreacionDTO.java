package com.satoshihans.practicalaboralsql.factura;

import java.util.List;

import com.satoshihans.practicalaboralsql.lineaservicio.LineaDeServiciosCreacionDesdeFacturaDTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FacturaCreacionDTO {
    private String idCliente;
    // private Double importe;
    private List<LineaDeServiciosCreacionDesdeFacturaDTO> lineasDeServicios;
}
