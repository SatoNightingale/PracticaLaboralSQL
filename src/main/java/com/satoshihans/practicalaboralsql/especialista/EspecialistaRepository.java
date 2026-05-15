package com.satoshihans.practicalaboralsql.especialista;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EspecialistaRepository extends JpaRepository<Especialista, Long> {

	Integer countByDepartamento(Long idDepartamento);

	@Query("SELECT e.id FROM Especialista e WHERE e.idDepartamento = :idDepartamento")
	List<Long> findAllByDepartamento(Long idDepartamento);
}
