package com.minegocio.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minegocio.base.domain.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
	Empleado findByDocumento(String documento);
}
