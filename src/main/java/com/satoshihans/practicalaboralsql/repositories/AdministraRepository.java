package com.satoshihans.practicalaboralsql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satoshihans.practicalaboralsql.models.entity.Administra;


public interface AdministraRepository extends JpaRepository<Administra, Long> {

    void deleteByUsuarioAndAsignadoAndLineaServicios(Long idUsuario, Long idAsignado, Long idLineaServicios);

    Administra getByUsuarioAndAsignadoAndLineaServicios(Long idUsuario, Long idAsignado, Long idLineaServicios);

}
