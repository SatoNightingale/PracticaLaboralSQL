package com.satoshihans.practicalaboralsql.periodo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodoRepository extends JpaRepository<Periodo, Long> {

    @Query("SELECT p FROM Periodo p ORDER BY p.fechaInicio DESC LIMIT 1")
    Periodo getPeriodoActual();

}
