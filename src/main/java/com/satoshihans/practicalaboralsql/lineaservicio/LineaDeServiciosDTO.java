package com.satoshihans.practicalaboralsql.lineaservicio;

import java.util.List;

import com.satoshihans.practicalaboralsql.asignacion.dto.TrabajaDTO;
import com.satoshihans.practicalaboralsql.servicio.ServicioDTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LineaDeServiciosDTO {
    private Long id;
    private Long id_factura;
    private ServicioDTO servicio;
    private List<TrabajaDTO> contratados;
    private Double importe;
}
