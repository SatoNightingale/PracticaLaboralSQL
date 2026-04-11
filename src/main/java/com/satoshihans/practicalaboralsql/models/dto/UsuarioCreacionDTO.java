package com.satoshihans.practicalaboralsql.models.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioCreacionDTO {
    private String nombre, contrasena, email;
}
