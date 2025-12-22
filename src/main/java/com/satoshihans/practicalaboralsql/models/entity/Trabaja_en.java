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

    @JoinColumn(name = "idEspecialista", referencedColumnName = "id")
    private Especialista especialista;

    @JoinColumn(name = "idServicio", referencedColumnName = "id")
    private LineaDeServicios idServicio;

    @Column(name = "importe")
    private Float importe;
}
