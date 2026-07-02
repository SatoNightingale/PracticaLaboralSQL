package com.satoshihans.practicalaboralsql.lineaservicio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LineaDeServiciosRepository extends JpaRepository<LineaDeServicios, Long> {
    
    List<LineaDeServicios> findAllByFacturaId(Long facturaId);

    @Query("SELECT COALESCE(SUM(ls.repartido), 0) FROM LineaDeServicios ls WHERE ls.factura.id = :facturaId")
    Double totalRepartidoPorFactura(Long facturaId);

    @Query("SELECT COALESCE(SUM(ls.repartido), 0) FROM LineaDeServicios ls WHERE ls.factura.periodo.id = :periodoId")
    Double totalRepartidoPorPeriodo(Long periodoId);
}
