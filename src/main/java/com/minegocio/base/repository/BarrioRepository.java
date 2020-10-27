package com.minegocio.base.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minegocio.base.domain.Barrio;
import com.minegocio.base.domain.Ciudad;

public interface BarrioRepository extends JpaRepository<Barrio, Long>{
	List<Barrio> findByCiudad(Ciudad ciudad);
}
