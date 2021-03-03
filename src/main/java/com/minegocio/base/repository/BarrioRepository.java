package com.minegocio.base.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minegocio.base.domain.Barrio;
import com.minegocio.base.domain.Ciudad;

@Repository
public interface BarrioRepository extends JpaRepository<Barrio, Long>{
	List<Barrio> findByCiudad(Ciudad ciudad);
	
	Barrio findByNombre(String nombre);
}
