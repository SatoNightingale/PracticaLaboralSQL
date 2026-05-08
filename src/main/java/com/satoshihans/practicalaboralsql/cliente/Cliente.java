package com.satoshihans.practicalaboralsql.cliente;

import com.satoshihans.practicalaboralsql.localizacion.Municipio;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String codigoId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "id_municipio", referencedColumnName = "id")
    private Municipio municipio;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String telefono;
}
