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
    private Long id_servicio;
    private List<Trabaja_enDTO> contratados;
    private Double importe;
    
    // public static LineaDeServiciosDTO fromEntity(LineaDeServicios entity){
    //     return new LineaDeServiciosDTO(
    //         entity.getId(),
    //         entity.getImporte(),
    //         entity.getFactura().getId(),
    //         entity.getServicio().getId(),
    //         entity.getAdministrador().getId()
    //     );
    // }
}
