package com.satoshihans.practicalaboralsql.periodo;

import java.time.LocalDate;
import java.util.List;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PeriodoCreacionDTO {
    private LocalDate fechaInicio, fechaFin;
    private List<PlanPeriodoCreacionDTO> planes;
}
