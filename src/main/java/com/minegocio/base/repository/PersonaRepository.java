package com.minegocio.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minegocio.base.domain.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
	Persona findByDocumento(String documento);
}
