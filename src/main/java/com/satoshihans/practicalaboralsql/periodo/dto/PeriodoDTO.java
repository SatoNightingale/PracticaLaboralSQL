package com.satoshihans.practicalaboralsql.periodo.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PeriodoDTO {
    private Long id;
    private boolean abierto;
    private LocalDate fechaInicio, fechaFin;
    private Double ingresosTotales;
    private List<PlanPeriodoDTO> planes;
}
