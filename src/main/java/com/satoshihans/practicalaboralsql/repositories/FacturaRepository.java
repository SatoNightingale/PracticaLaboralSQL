package com.satoshihans.practicalaboralsql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satoshihans.practicalaboralsql.models.entity.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
    
}
