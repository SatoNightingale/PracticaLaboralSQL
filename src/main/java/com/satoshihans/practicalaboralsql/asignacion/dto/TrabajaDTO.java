package com.satoshihans.practicalaboralsql.asignacion.dto;

import com.satoshihans.practicalaboralsql.especialista.dto.EspecialistaDTO;

import lombok.*;

@Data
@AllArgsConstructor
public class TrabajaDTO {
    private EspecialistaDTO especialista;
    private Double importe;
}
