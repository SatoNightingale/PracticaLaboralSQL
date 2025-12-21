package com.satoshihans.practicalaboralsql.models.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "Cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private String idCliente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "gmail")
    private String gmail;

    @Column(name = "telefono")
    private int telefono;

}
