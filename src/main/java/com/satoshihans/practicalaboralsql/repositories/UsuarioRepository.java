package com.satoshihans.practicalaboralsql.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satoshihans.practicalaboralsql.models.entity.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNombreAndContrasena(String nombre, String contrasena);

    boolean existsByNombre(String nombre);
}
