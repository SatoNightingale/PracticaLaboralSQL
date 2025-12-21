package com.satoshihans.practicalaboralsql.models.entity;

import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cod")
    private String cod;

    @Column(name = "gmail")
    private String gmail;
}
