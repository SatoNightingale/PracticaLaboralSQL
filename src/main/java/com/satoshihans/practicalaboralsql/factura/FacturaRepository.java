package com.satoshihans.practicalaboralsql.factura;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface FacturaRepository extends JpaRepository<Factura, Long> {
    
	List<Factura> findByPeriodoId(Long periodoId);

	@Query("SELECT COALESCE(SUM(f.importeTotal), 0) FROM Factura f WHERE f.periodo.id = :periodoId")
	Double sumImporteTotalByPeriodoId (Long periodoId);

	@Query("SELECT SUM(COALESCE(importeTotal, 0)) FROM Factura")
	Double totalFacturadoGlobal();

	// @Query("SELECT ALL FROM Factura f ORDER BY f.fechaEmision DESC")
	List<Factura> findAllByOrderByFechaEmisionDesc();
}
