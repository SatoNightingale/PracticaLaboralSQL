package com.satoshihans.practicalaboralsql.especialista.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EspecialistaAsignacionDTO {
    private Long idEspecialista;
    // private Long idLineaServicio;
    private Long idUsuarioAdmin;
    private Double importe;
}
