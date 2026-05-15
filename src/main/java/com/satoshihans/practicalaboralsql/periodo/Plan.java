package com.satoshihans.practicalaboralsql.periodo;

import com.satoshihans.practicalaboralsql.departamento.Departamento;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idPeriodo", referencedColumnName = "id")
    private Periodo periodo;

    @ManyToOne
    @JoinColumn(name = "idDepartamento", referencedColumnName = "id")
    private Departamento departamento;

    @Column(name = "plan")
    private Double plan;
}
