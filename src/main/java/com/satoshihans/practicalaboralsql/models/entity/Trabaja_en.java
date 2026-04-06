package com.satoshihans.practicalaboralsql.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Trabaja_en")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Trabaja_en {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idEspecialista", referencedColumnName = "id")
    private Especialista especialista;

    @ManyToOne
    @JoinColumn(name = "idServicio", referencedColumnName = "id")
    private LineaDeServicios idServicio;

    @Column(name = "importe")
    private Float importe;
}
