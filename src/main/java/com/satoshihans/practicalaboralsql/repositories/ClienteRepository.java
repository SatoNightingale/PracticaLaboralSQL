package com.satoshihans.practicalaboralsql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satoshihans.practicalaboralsql.models.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

}
