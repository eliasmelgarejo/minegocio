package com.minegocio.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minegocio.base.domain.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>{
	Pais findByNombre(String nombre);
}
