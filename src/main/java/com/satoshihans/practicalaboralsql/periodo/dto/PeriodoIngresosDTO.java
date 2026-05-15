package com.satoshihans.practicalaboralsql.periodo.dto;

import java.time.LocalDate;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeriodoIngresosDTO {
	private Long id;
	private LocalDate fecha;
	private Double ingresos;
}
