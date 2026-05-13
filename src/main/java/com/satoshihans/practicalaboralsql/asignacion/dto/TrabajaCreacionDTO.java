package com.satoshihans.practicalaboralsql.asignacion.dto;

import java.time.LocalDate;

import lombok.*;

@Data
@AllArgsConstructor
public class TrabajaCreacionDTO {
    private Long idEspecialista;
    private Double importe;
    private LocalDate fechaContratacion;
}
