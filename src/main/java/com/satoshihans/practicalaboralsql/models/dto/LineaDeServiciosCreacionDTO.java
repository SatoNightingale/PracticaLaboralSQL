package com.satoshihans.practicalaboralsql.models.dto;

import java.util.List;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LineaDeServiciosCreacionDTO {
    private Long id_servicio;
    private List<TrabajaCreacionDTO> contratos;
}
