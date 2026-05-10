package com.satoshihans.practicalaboralsql.asignacion;

import java.time.LocalDate;

import lombok.*;

@Data
@AllArgsConstructor
public class TrabajaCreacionDTO {
    private Long idEspecialista;
    private Double importe;
    private LocalDate fechaContratacion;
}
