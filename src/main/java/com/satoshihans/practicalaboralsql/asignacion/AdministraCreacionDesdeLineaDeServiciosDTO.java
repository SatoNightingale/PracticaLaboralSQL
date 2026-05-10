package com.satoshihans.practicalaboralsql.asignacion;

import java.time.LocalDate;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdministraCreacionDesdeLineaDeServiciosDTO {
    private Long idUsuario;
    private Long idEspecialistaAsignado;
    private LocalDate fechaAsignacion;
}
