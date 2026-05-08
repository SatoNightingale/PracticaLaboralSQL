package com.satoshihans.practicalaboralsql.asignacion;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministraRepository extends JpaRepository<Administra, Long> {

    void deleteByUsuarioAndAsignadoAndLineaServicios(Long idUsuario, Long idAsignado, Long idLineaServicios);

    Administra getByUsuarioAndAsignadoAndLineaServicios(Long idUsuario, Long idAsignado, Long idLineaServicios);

}
