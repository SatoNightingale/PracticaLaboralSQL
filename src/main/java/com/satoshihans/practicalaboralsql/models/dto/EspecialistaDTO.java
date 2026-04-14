package com.satoshihans.practicalaboralsql.models.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EspecialistaDTO {
    private Long id;
    private String nombre, especialidad;
    private DepartamentoDTO departamento;
}
