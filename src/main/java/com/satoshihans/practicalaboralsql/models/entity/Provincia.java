package com.satoshihans.practicalaboralsql.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Provincia")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Provincia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "nombre")
    private String nombre;
    
}
