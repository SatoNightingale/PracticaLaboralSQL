package com.satoshihans.practicalaboralsql.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LineaDeServicio")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class LineaDeServicios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFactura")
    private String idFactura;

    @Column(name = "idServicio")
    private String idServicio;
}
