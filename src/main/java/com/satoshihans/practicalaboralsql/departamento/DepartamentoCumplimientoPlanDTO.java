package com.satoshihans.practicalaboralsql.departamento;

import java.util.List;

import com.satoshihans.practicalaboralsql.especialista.dto.EspecialistaCumplimientoPlanDTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartamentoCumplimientoPlanDTO {
	private Long idDepto;
	private Long idPeriodo;
	private Double totalIngresado;
	private Double plan;
	private Double porcientoCumplido;
	private List<EspecialistaCumplimientoPlanDTO> especialistas;
}
