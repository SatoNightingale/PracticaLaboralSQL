package com.satoshihans.practicalaboralsql.models.dto;

import java.util.List;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LineaDeServiciosCreacionDesdeFacturaDTO {
    private Long idServicio;
    private List<TrabajaCreacionDTO> contratos;
}
