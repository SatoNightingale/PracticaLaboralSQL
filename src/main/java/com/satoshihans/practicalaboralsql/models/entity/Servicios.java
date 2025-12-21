package com.satoshihans.practicalaboralsql.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Servicios")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Servicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idServicio")
    private String idServicio;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;
}
