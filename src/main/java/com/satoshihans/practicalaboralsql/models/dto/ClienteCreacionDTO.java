package com.satoshihans.practicalaboralsql.models.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteCreacionDTO {
    private String telefono, nombre, direccion, gmail;
    private MunicipioDTO municipio;
}
