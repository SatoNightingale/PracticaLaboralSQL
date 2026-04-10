package com.satoshihans.practicalaboralsql.models.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Administra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private LineaDeServicios lineaServicios; // Linea a la que se asigno un especialista

    @OneToOne
    private Especialista asignado; // Especialista asignado a la linea de servicios

    @OneToOne
    private Usuario usuario; // Usuario que realiza la asignacion
    
    private LocalDateTime fechaAsignacion; // Fecha de la asignacion
}
