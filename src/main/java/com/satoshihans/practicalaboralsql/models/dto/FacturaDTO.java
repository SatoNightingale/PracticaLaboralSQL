package com.satoshihans.practicalaboralsql.models.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class FacturaDTO {
    private Long id; 
    private ClienteDTO cliente;
    private Double importe;
    private String fecha;
}
