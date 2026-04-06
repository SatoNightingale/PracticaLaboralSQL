package com.satoshihans.practicalaboralsql.models.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class Trabaja_enDTO {
    private LineaDeServiciosDTO lineaDeServicios;
    private EspecialistaDTO especialista;
    private Float importe;
}
