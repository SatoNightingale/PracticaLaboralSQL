package com.satoshihans.practicalaboralsql.models.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class TrabajaDTO {
    private EspecialistaDTO especialista;
    private Float importe;
}
