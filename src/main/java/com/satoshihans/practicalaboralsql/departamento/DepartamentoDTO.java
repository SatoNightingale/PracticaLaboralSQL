package com.satoshihans.practicalaboralsql.departamento;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartamentoDTO {
    private Long id;
    private String nombre, direccion;
}
