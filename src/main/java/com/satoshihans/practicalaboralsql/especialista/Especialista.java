package com.satoshihans.practicalaboralsql.especialista;

import com.satoshihans.practicalaboralsql.departamento.Departamento;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Especialista")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Especialista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    // Cada especialista va en un solo departamento
    @ManyToOne
    @JoinColumn(name = "idDepartamento", referencedColumnName = "id")
    private Departamento departamento;

    @Column(name = "especialidad")
    private String especialidad;
}
