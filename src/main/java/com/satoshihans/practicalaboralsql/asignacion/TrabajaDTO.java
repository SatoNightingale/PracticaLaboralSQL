package com.satoshihans.practicalaboralsql.asignacion;

import com.satoshihans.practicalaboralsql.especialista.EspecialistaDTO;

import lombok.*;

@Data
@AllArgsConstructor
public class TrabajaDTO {
    private EspecialistaDTO especialista;
    private Double importe;
}
