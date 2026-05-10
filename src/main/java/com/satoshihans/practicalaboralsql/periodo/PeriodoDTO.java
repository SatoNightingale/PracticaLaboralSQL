package com.satoshihans.practicalaboralsql.periodo;

import java.time.LocalDate;
import java.util.List;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PeriodoDTO {
    private boolean abierto;
    private LocalDate fechaInicio, fechaFin;
    private Double ingresosTotales;
    private List<PlanPeriodoDTO> planes;
}
