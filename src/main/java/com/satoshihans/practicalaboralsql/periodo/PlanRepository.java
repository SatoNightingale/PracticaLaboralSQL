package com.satoshihans.practicalaboralsql.periodo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {

    @Query("SELECT p FROM Plan p WHERE p.departamento.id = :departamentoId ORDER BY p.periodo.fechaInicio DESC LIMIT 1")
    Plan getPlanActualByDepartamentoId(Long departamentoId);
}
