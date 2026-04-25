package com.satoshihans.practicalaboralsql.events;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FacturaModificadaEvent {
    private Long idFactura;
    private Double importeTotal;
}
