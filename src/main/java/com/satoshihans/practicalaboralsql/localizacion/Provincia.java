package com.satoshihans.practicalaboralsql.localizacion;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Provincia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Provincia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "provincia")
    private List<Municipio> municipios;
}
