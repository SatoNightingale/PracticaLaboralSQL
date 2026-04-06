package com.satoshihans.practicalaboralsql.models.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ServicioDTO {
    private @Getter @Setter Long id;
    private @Getter @Setter String nombre, descripcion;
}
