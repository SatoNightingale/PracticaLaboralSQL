package com.satoshihans.practicalaboralsql.models.dto;

import java.util.List;

// import com.satoshihans.practicalaboralsql.models.entity.LineaDeServicios;

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
