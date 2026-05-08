package com.satoshihans.practicalaboralsql.usuario;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioAutenticacionDTO {
    private String nombre, contrasena;
}
