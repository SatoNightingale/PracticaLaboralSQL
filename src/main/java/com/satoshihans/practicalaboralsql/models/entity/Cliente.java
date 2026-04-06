package com.satoshihans.practicalaboralsql.models.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;
    
    @ManyToOne
    @JoinColumn(name = "id_municipio", referencedColumnName = "id")
    private Municipio municipio;
    
    @Column(name = "gmail")
    private String gmail;

    @Column(name = "telefono")
    private String telefono;

}
