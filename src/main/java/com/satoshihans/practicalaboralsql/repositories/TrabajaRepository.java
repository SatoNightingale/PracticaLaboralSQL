package com.satoshihans.practicalaboralsql.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satoshihans.practicalaboralsql.models.entity.Trabaja;


public interface TrabajaRepository extends JpaRepository<Trabaja, Long> {
    Optional<Trabaja> findByEspecialistaIdAndLineaServiciosId(Long idEspecialista, Long idLineaServicios);
}
