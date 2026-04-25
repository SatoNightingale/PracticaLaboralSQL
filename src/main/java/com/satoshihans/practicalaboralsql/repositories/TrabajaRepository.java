package com.satoshihans.practicalaboralsql.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.satoshihans.practicalaboralsql.models.entity.Trabaja;


public interface TrabajaRepository extends JpaRepository<Trabaja, Long> {
    Optional<Trabaja> findByEspecialistaIdAndLineaServiciosId(Long idEspecialista, Long idLineaServicios);

    @Query("SELECT COALESCE(SUM(importe), 0) FROM Trabaja tr WHERE tr.lineaServicios.id = :lineaId")
    Double sumImporteByLineaServiciosId(@Param("lineaId") Long id);

    void deleteByEspecialistaAndLineaServicios(Long idEspecialista, Long idLineaServicios);
}
