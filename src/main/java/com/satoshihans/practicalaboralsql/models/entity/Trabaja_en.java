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
    @Column(name = "idEspecialista")
    private String idEspecialista;

    @Column(name = "idServicio")
    private String idServicio;

    @Column(name = "importe")
    private Float importe;
}
