package com.minegocio.base.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minegocio.base.domain.Ciudad;
import com.minegocio.base.domain.Departamento;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
	List<Ciudad> findByDepartamento(Departamento departamento);
}
