package com.satoshihans.practicalaboralsql.lineaservicio;

import java.util.List;

import com.satoshihans.practicalaboralsql.asignacion.dto.TrabajaCreacionDTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LineaDeServiciosCreacionDTO {
    private Long idFactura;
    private Long idUsuarioAdmin;
    private Long idServicio;
    private Double importe;
    private List<TrabajaCreacionDTO> contratos;
}