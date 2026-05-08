package com.satoshihans.practicalaboralsql.shared.events;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FacturaModificadaEvent {
    private Long idFactura;
    private Double importeTotal;
}
