package com.satoshihans.practicalaboralsql.models.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MunicipioDTO {
    private Long id;
    private String nombre;
    private ProvinciaDTO provincia;
}
