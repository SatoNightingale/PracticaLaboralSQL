package com.satoshihans.practicalaboralsql.models.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteDTO {
    private Long id;
    private String telefono, nombre, direccion, gmail;
    private Long id_municipio;
}
