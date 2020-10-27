package com.minegocio.base.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minegocio.base.domain.Departamento;
import com.minegocio.base.domain.Pais;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
	List<Departamento> findByPais(Pais pais);
}
