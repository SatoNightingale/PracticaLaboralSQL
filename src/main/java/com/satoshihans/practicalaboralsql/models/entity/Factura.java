package com.satoshihans.practicalaboralsql.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Factura")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "idCliente")
    private String idCliente;
}
