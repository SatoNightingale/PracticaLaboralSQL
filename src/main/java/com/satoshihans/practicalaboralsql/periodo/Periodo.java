package com.satoshihans.practicalaboralsql.periodo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.satoshihans.practicalaboralsql.factura.Factura;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Periodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean abierto;
    
    private LocalDate fechaInicio, fechaFin;

    @OneToMany(mappedBy = "periodo", cascade = CascadeType.ALL)
    private List<Plan> planes = new ArrayList<>();

    @OneToMany(mappedBy = "periodo")
    private List<Factura> facturas = new ArrayList<>();

    private Double ingresosTotales;
}