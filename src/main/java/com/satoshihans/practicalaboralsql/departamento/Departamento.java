package com.satoshihans.practicalaboralsql.departamento;

import java.util.List;

import com.satoshihans.practicalaboralsql.especialista.Especialista;
import com.satoshihans.practicalaboralsql.periodo.Plan;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Departamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    // Cada departamento tiene varios especialistas
    private List<Especialista> especialistas;

    @OneToMany
    private List<Plan> historialPlanes;
}
