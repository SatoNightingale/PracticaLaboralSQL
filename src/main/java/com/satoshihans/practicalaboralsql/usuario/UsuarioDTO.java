package com.satoshihans.practicalaboralsql.usuario;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioDTO {
    private Long id;
    private String nombre, email;
}
