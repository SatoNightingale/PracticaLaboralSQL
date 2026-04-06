package com.satoshihans.practicalaboralsql.models.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MunicipioCreacionDTO {
    private String nombre;
    private Long id_provincia;
    private String nombre_provincia;
}
