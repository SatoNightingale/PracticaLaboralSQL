package com.satoshihans.practicalaboralsql.usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNombre(String nombre);

    Optional<Usuario> findByNombreAndContrasena(String nombre, String contrasena);

    boolean existsByNombre(String nombre);

    // boolean existsByIdAndAutenticadoTrue(Long id);
}
