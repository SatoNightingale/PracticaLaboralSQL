package com.satoshihans.practicalaboralsql.asignacion.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdministraCreacionDTO {
    private Long idUsuario;
    private Long idEspecialistaAsignado;
    private Long idLineaServicios;
}
