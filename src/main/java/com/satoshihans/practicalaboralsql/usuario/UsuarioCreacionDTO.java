package com.satoshihans.practicalaboralsql.usuario;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioCreacionDTO {
    private String nombre, contrasena, email;
}
