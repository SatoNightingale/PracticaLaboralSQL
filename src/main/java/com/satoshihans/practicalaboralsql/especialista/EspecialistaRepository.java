package com.satoshihans.practicalaboralsql.especialista;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecialistaRepository extends JpaRepository<Especialista, Long> {

	Integer countByDepartamento(Long idDepartamento);
}
