package com.satoshihans.practicalaboralsql.models.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartamentoDTO {
    private Long id;
    private String nombre, direccion;
}
