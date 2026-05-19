package com.satoshihans.practicalaboralsql.factura;

import java.time.LocalDateTime;
import java.util.List;

import com.satoshihans.practicalaboralsql.cliente.Cliente;
import com.satoshihans.practicalaboralsql.lineaservicio.LineaDeServicios;
import com.satoshihans.practicalaboralsql.periodo.Periodo;

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
    private Long id;

    @Column(name = "fecha")
    private LocalDateTime fechaEmision;

    @Column(name = "importe")
    private Double importeTotal;

    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idPeriodo", referencedColumnName = "id")
    private Periodo periodo;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<LineaDeServicios> lineasDeServicio;
    
}
