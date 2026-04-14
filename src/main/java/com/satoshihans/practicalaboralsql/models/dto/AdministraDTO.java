package com.satoshihans.practicalaboralsql.models.dto;

import java.time.LocalDateTime;

import lombok.*;

@Data
@AllArgsConstructor
public class AdministraDTO {
    private Long id;
    private UsuarioDTO usuario;
    private EspecialistaDTO especialistaAsignado;
    private Long id_LineaDeServicio;
    private LocalDateTime fechaAsignacion;
}
