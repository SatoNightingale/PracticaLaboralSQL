package com.satoshihans.practicalaboralsql.especialista.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EspecialistaCumplimientoPlanDTO {
	private Long idEspecialista;
	private Double ingresosTotales;
	private Double porcentajeCumplido;
}
