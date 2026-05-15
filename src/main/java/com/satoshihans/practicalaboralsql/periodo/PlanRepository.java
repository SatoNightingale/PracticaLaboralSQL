package com.satoshihans.practicalaboralsql.periodo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {

    @Query("SELECT p.plan FROM Plan p WHERE p.idDepartamento = :idDepartamento AND p.idPeriodo = :idPeriodo")
    Double getPlanByDepartamento(Long idDepartamento, Long idPeriodo);
}
