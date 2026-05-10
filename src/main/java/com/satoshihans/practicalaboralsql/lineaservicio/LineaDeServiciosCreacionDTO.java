package com.satoshihans.practicalaboralsql.lineaservicio;

import java.util.List;

import com.satoshihans.practicalaboralsql.asignacion.TrabajaCreacionDTO;
// import com.satoshihans.practicalaboralsql.asignacion.TrabajaCreacionDesdeLineaDeServiciosDTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LineaDeServiciosCreacionDTO {
    private Long idFactura;
    private Long idUsuarioAdmin;
    private Long idServicio;
    private List<TrabajaCreacionDTO> contratos;
}