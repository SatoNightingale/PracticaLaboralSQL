package com.satoshihans.practicalaboralsql.asignacion;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TrabajaRepository extends JpaRepository<Trabaja, Long> {
    Optional<Trabaja> findByEspecialistaIdAndLineaServiciosId(Long idEspecialista, Long idLineaServicios);

    // @Query("SELECT COALESCE(SUM(importe), 0) FROM Trabaja tr WHERE tr.lineaServicios.id = :lineaId")
    // Double sumImporteByLineaServiciosId(@Param("lineaId") Long id);

    void deleteByEspecialistaAndLineaServicios(Long idEspecialista, Long idLineaServicios);

    @Query("SELECT COALESCE(SUM(t.importe), 0.0) FROM Trabaja t WHERE t.fechaContratacion BETWEEN :fechaInicio AND :fechaFin")
    Double getIngresosTotalesPorPeriodo(LocalDate fechaInicio, LocalDate fechaFin);

    @Query("SELECT COALESCE(SUM(t.importe), 0.0) FROM Trabaja t WHERE t.especialista.id = :idEspecialista AND t.fechaContratacion BETWEEN :fechaInicio AND :fechaFin")
    Double getIngresosTotalesEspecialistaPorPeriodo(Long idEspecialista, LocalDate fechaInicio, LocalDate fechaFin);
}
