package com.satoshihans.practicalaboralsql.models.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.*;

@Data
@AllArgsConstructor
public class FacturaDTO {
    private Long id;
    private LocalDateTime fechaEmision;
    private Double importeTotal;
    private Long id_cliente;
    private List<LineaDeServiciosDTO> lineasDeServicios;

    // public static FacturaDTO fromEntity(Factura entity){
    //     return new FacturaDTO(
    //         entity.getId(),
    //         entity.getFechaEmision(),
    //         entity.getImporteTotal(),
    //         entity.getCliente().getId()
    //     );
    // }
}
