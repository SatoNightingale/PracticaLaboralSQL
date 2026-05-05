package com.satoshihans.practicalaboralsql.models.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteDTO {
    private String codigoId;
    private String telefono, nombre, direccion, email;
    private MunicipioDTO municipio;
}
