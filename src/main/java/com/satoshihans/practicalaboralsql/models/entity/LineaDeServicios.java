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
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idFactura", referencedColumnName = "id")
    private Factura factura;

    @Column(name = "importe")
    private double importe;

    @ManyToOne
    @JoinColumn(name = "idServicio", referencedColumnName = "id")
    private Servicio servicio;

    @ManyToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "id")
    private Usuario usuario;
}
