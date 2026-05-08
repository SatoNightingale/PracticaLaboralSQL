package com.satoshihans.practicalaboralsql.periodo;

import com.satoshihans.practicalaboralsql.departamento.Departamento;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Periodo periodo;

    @ManyToOne
    private Departamento departamento;

    private Double plan;
}
