package com.satoshihans.practicalaboralsql.lineaservicio;

import java.util.List;

import com.satoshihans.practicalaboralsql.asignacion.Administra;
import com.satoshihans.practicalaboralsql.asignacion.Trabaja;
import com.satoshihans.practicalaboralsql.factura.Factura;
import com.satoshihans.practicalaboralsql.servicio.Servicio;

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
    private List<Trabaja> contratados;

    @OneToMany(mappedBy = "id")
    // Una linea de servicios tiene varias asignaciones
    private List<Administra> asignaciones;
}
