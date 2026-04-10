package com.satoshihans.practicalaboralsql.models.entity;

import java.util.List;

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

    // A una factura le corresponden varias lineas de servicio
    @ManyToOne
    @JoinColumn(name = "idFactura", referencedColumnName = "id")
    private Factura factura;

    @Column(name = "importe")
    private double importe;

    // Una linea de servicio tiene un servicio asignado, pero un mismo servicio puede estar asignado a varias lineas
    @ManyToOne
    @JoinColumn(name = "idServicio", referencedColumnName = "id")
    private Servicio servicio;

    // Una linea de servicios tiene varios especialistas contratados (y cada especialista tiene asignado su propio importe)
    @OneToMany(mappedBy = "id")
    private List<Trabaja_en> contratados;

    @OneToMany(mappedBy = "id")
    // Varios usuarios pueden ser administradores de una misma linea de servicios
    private List<Administra> administradores;
}
