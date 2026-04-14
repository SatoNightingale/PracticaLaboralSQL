package com.satoshihans.practicalaboralsql.models.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServicioDTO {
    private Long id;
    private String nombre, descripcion;
}
