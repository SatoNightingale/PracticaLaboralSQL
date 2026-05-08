package com.satoshihans.practicalaboralsql.localizacion;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MunicipioDTO {
    private Long id;
    private String nombre;
    private ProvinciaDTO provincia;
}
