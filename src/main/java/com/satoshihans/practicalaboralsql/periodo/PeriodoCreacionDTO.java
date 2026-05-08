package com.satoshihans.practicalaboralsql.periodo;

import java.time.LocalDate;
import java.util.List;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PeriodoCreacionDTO {
    private LocalDate inicio, fin;
    private List<PlanPeriodoCreacionDTO> planes;
}
