package com.satoshihans.practicalaboralsql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.satoshihans.practicalaboralsql.models.entity.LineaDeServicios;

public interface LineaDeServiciosRepository extends JpaRepository<LineaDeServicios, Long> {

    @Query("SELECT COALESCE(SUM(ls.importe), 0) FROM LineaDeServicios ls WHERE ls.factura.id = :facturaId")
    Double sumImporteByFacturaId(@Param("facturaId") Long facturaId);
    
}
