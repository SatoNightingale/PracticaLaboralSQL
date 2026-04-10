package com.satoshihans.practicalaboralsql.models.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EspecialistaCreacionDTO {
    private String nombre, especialidad;
    private Long idDepartamento;
    private DepartamentoCreacionDTO departamento;
}
