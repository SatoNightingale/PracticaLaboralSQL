package com.satoshihans.practicalaboralsql.periodo;

import java.time.LocalDate;
import java.util.List;

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
    
    private LocalDate inicio, fin;

    @OneToMany(mappedBy = "periodo")
    private List<Plan> planes;

    private Double ingresosTotales;
}