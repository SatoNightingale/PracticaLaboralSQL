package com.satoshihans.practicalaboralsql.autenticacion;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginDTO {
    private @NotBlank String nombre, contrasena;
}
