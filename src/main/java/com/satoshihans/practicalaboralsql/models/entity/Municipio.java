package com.satoshihans.practicalaboralsql.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Municipio")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idP")
    private String idP;

    @Column(name = "id")
    private String id;

    @Column(name = "nombre")
    private String nombre;
}
