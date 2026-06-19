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
@Table(name = "linea_de_servicios")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class LineaDeServicios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // A una factura le corresponden varias lineas de servicio. Una línea de servicio siempre pertenece a una factura existente.
    @ManyToOne
    @JoinColumn(name = "idFactura", referencedColumnName = "id", nullable = false)
    private Factura factura;

    /**
     * El importe de la linea de servicios. Fijo, no se modifica despues de entrar en el sistema
     */
    @Column(name = "importe")
    private Double importe;

    /**
     * La parte del importe de esta linea que se ha repartido entre los especialistas
     */
    @Column(name = "repartido")
    private Double repartido;

    // Una linea de servicio tiene un servicio asignado, pero un mismo servicio puede estar asignado a varias lineas
    @ManyToOne
    @JoinColumn(name = "idServicio", referencedColumnName = "id")
    private Servicio servicio;

    // Una linea de servicios tiene varios especialistas contratados (y cada especialista tiene asignado su propio importe)
    @OneToMany(mappedBy = "lineaServicios", cascade = CascadeType.ALL)
    private List<Trabaja> contratados;

    @OneToMany(mappedBy = "lineaServicios", cascade = CascadeType.ALL)
    // Una linea de servicios tiene varias asignaciones
    private List<Administra> asignaciones;
}
