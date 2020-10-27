package com.minegocio.base.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minegocio.base.domain.Ciudad;
import com.minegocio.base.domain.Departamento;

public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
	List<Ciudad> findByDepartamento(Departamento departamento);
}
