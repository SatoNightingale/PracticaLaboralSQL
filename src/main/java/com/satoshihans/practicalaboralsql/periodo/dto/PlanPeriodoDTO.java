package com.satoshihans.practicalaboralsql.periodo.dto;

import com.satoshihans.practicalaboralsql.departamento.DepartamentoDTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlanPeriodoDTO {
    private DepartamentoDTO departamento;
    private Double plan;
}
