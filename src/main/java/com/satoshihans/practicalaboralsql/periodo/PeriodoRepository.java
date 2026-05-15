package com.satoshihans.practicalaboralsql.periodo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.satoshihans.practicalaboralsql.periodo.dto.PeriodoIngresosDTO;

@Repository
public interface PeriodoRepository extends JpaRepository<Periodo, Long> {

    @Query("SELECT p FROM Periodo p ORDER BY p.fechaInicio DESC LIMIT 1")
    Periodo getPeriodoActual();

    @Query("SELECT p FROM Periodo p WHERE :fecha BETWEEN p.fechaInicio AND p.fechaFin")
    Periodo getPeriodoByFecha(@Param(value = "fecha") LocalDate fecha);

    @Query("SELECT new com.satoshihans.practicalaboralsql.periodo.dto.PeriodoIngresosDTO(p.id, p.fechaFin, p.ingresosTotales) FROM Periodo p ORDER BY p.fechaFin ASC NULLS LAST")
    List<PeriodoIngresosDTO> findAllIngresosTotales();
}
