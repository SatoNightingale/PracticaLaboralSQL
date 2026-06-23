package com.satoshihans.practicalaboralsql.periodo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface PlanRepository extends JpaRepository<Plan, Long> {

    @Query("SELECT p.plan FROM Plan p WHERE p.departamento.id = :idDepartamento AND p.periodo.id = :idPeriodo")
    Double getPlanByDepartamento(Long idDepartamento, Long idPeriodo);

    @Query("SELECT SUM(COALESCE(p.plan, 0)) FROM Plan p WHERE p.periodo.id = :idPeriodo")
    Double getPlanPeriodo(Long idPeriodo);
}
