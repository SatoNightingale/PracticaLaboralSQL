package com.satoshihans.practicalaboralsql.asignacion;

import java.time.LocalDate;

import com.satoshihans.practicalaboralsql.especialista.Especialista;
import com.satoshihans.practicalaboralsql.lineaservicio.LineaDeServicios;
import com.satoshihans.practicalaboralsql.usuario.Usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Administra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Usuario usuario; // Usuario que realiza la asignacion

    @OneToOne
    private Especialista asignado; // Especialista asignado a la linea de servicios

    @ManyToOne
    private LineaDeServicios lineaServicios; // Linea a la que se asigno un especialista

    private LocalDate fechaAsignacion; // Fecha de la asignacion
}
