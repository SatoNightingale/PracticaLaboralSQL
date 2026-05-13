package com.satoshihans.practicalaboralsql.departamento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

	@Query("SELECT id FROM Departamento")
	List<Long> getAllIds();
}
