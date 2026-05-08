package com.satoshihans.practicalaboralsql.factura;

import java.time.LocalDateTime;
import java.util.List;

import com.satoshihans.practicalaboralsql.cliente.ClienteDTO;
import com.satoshihans.practicalaboralsql.lineaservicio.LineaDeServiciosDTO;

import lombok.*;

@Data
@AllArgsConstructor
public class FacturaDTO {
    private Long id;
    private LocalDateTime fechaEmision;
    private Double importeTotal;
    private ClienteDTO cliente;
    private List<LineaDeServiciosDTO> lineasDeServicio;
}
