package com.satoshihans.practicalaboralsql.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Especialistas")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Especialista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "idDepartamento")
    private String idDepartamento;

    @Column(name = "especialidad")
    private String especialidad;
    
}
