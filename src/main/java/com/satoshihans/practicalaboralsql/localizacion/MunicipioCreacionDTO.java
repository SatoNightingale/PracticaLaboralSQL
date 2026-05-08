package com.satoshihans.practicalaboralsql.localizacion;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MunicipioCreacionDTO {
    private String nombre;
    private Long idProvincia;
    private String nombreProvincia;
}
