package com.satoshihans.practicalaboralsql.asignacion.dto;

import java.time.LocalDate;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdministraCreacionDTO {
    private Long idUsuario;
    private Long idEspecialistaAsignado;
    private Long idLineaServicios;
    private LocalDate fechaAsignacion;
}
