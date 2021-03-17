package com.minegocio.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minegocio.base.domain.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
	Empleado findByCodigo(String codigo);
}
