package com.satoshihans.practicalaboralsql.asignacion;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministraRepository extends JpaRepository<Administra, Long> {

    void deleteByUsuarioIdAndAsignadoIdAndLineaServiciosId(Long idUsuario, Long idAsignado, Long idLineaServicios);

    Administra getByUsuarioIdAndAsignadoIdAndLineaServiciosId(Long idUsuario, Long idAsignado, Long idLineaServicios);

}
