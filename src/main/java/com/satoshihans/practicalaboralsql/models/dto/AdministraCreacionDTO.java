package com.satoshihans.practicalaboralsql.models.dto;

import java.time.LocalDateTime;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdministraCreacionDTO {
    private Long idUsuario;
    private Long idEspecialistaAsignado;
    private Long idLineaServicios;
    private LocalDateTime fechaAsignacion;
}
