package com.satoshihans.practicalaboralsql.especialista;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface EspecialistaRepository extends JpaRepository<Especialista, Long> {

	@Query("SELECT COUNT(e) FROM Especialista e WHERE e.departamento.id = :idDepartamento")
	Integer countByDepartamento(Long idDepartamento);

	@Query("SELECT id FROM Especialista e WHERE e.departamento.id = :idDepartamento")
	List<Long> findAllByDepartamento(Long idDepartamento);
}
