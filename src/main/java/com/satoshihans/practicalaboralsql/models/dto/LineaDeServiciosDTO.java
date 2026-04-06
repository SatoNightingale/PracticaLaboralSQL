package com.satoshihans.practicalaboralsql.models.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LineaDeServiciosDTO {
    private @Getter @Setter Long id;
    private @Getter @Setter Double importe;
    private @Getter @Setter FacturaDTO factura;
    private @Getter @Setter ServicioDTO servicio;
    private @Getter @Setter UsuarioDTO usuario;
    

}
