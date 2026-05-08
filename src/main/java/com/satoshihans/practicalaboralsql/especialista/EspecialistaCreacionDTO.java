package com.satoshihans.practicalaboralsql.especialista;

import com.satoshihans.practicalaboralsql.departamento.DepartamentoCreacionDTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EspecialistaCreacionDTO {
    private String nombre, especialidad;
    private Long idDepartamento;
    private DepartamentoCreacionDTO departamento;
}
