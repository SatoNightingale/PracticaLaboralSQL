package com.satoshihans.practicalaboralsql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satoshihans.practicalaboralsql.models.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}
