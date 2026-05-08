package com.satoshihans.practicalaboralsql.asignacion;

import com.satoshihans.practicalaboralsql.especialista.Especialista;
import com.satoshihans.practicalaboralsql.lineaservicio.LineaDeServicios;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Trabaja_en")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Trabaja {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Un especialista puede tener varios contratos
    @ManyToOne
    @JoinColumn(name = "idEspecialista", referencedColumnName = "id")
    private Especialista especialista;

    // Una linea de servicios consta de varios contratos
    @ManyToOne
    @JoinColumn(name = "idServicio", referencedColumnName = "id")
    private LineaDeServicios lineaServicios;

    // Cada especialista aporta a la linea de servicios su propio importe
    @Column(name = "importe")
    private Double importe;
}
