package com.satoshihans.practicalaboralsql.asignacion;

import java.time.LocalDateTime;

import com.satoshihans.practicalaboralsql.especialista.EspecialistaDTO;
import com.satoshihans.practicalaboralsql.usuario.UsuarioDTO;

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
