package com.satoshihans.practicalaboralsql.models.dto;

import java.util.List;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FacturaCreacionDTO {
    private Long idCliente;
    private Long idUsuarioAdmin;
    private List<LineaDeServiciosCreacionDTO> lineasDeServicios;
}
