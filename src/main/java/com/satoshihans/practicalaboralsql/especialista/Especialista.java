package com.satoshihans.practicalaboralsql.especialista;

import java.util.List;

import com.satoshihans.practicalaboralsql.asignacion.Trabaja;
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

    // Cada especialista va en un solo departamento. Un especialista siempre pertenece a un departamento existente.
    @ManyToOne
    @JoinColumn(name = "idDepartamento", referencedColumnName = "id", nullable = false)
    private Departamento departamento;

    @OneToMany(mappedBy = "especialista", cascade = CascadeType.ALL)
    private List<Trabaja> contratos;

    @Column(name = "especialidad")
    private String especialidad;
}
