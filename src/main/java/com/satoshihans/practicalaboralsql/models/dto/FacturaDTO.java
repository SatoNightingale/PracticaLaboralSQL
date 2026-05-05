package com.satoshihans.practicalaboralsql.models.dto;

import java.time.LocalDateTime;
import java.util.List;

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
