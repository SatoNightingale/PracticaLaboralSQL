package com.satoshihans.practicalaboralsql.asignacion;

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
