package com.satoshihans.practicalaboralsql.asignacion;

import java.time.LocalDateTime;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdministraCreacionDesdeLineaDeServiciosDTO {
    private Long idUsuario;
    private Long idEspecialistaAsignado;
    private LocalDateTime fechaAsignacion;
}
