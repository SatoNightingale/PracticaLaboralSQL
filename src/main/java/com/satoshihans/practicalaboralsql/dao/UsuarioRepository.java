package com.satoshihans.practicalaboralsql.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satoshihans.practicalaboralsql.models.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
