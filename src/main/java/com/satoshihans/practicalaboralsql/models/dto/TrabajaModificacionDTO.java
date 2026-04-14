package com.satoshihans.practicalaboralsql.models.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class TrabajaModificacionDTO {
    private Long idTrabaja;
    private Long idEspecialista;
    private Long idLineaDeServicios;
    private Double importe;
}
