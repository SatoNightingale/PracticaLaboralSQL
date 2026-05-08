package com.satoshihans.practicalaboralsql.especialista;

import com.satoshihans.practicalaboralsql.departamento.DepartamentoDTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EspecialistaDTO {
    private Long id;
    private String nombre, especialidad;
    private DepartamentoDTO departamento;
}
