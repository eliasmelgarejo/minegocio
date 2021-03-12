package com.minegocio.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minegocio.base.domain.Moneda;

@Repository
public interface MonedaRepository extends JpaRepository<Moneda, Long> {
	Moneda findBySimbolo(String simbolo);
	
	//EN EL CODIGO ORIGINAL ESTOS METODOS NO ESTABAN COMENTADOS
	//List<Moneda> findByPais(Pais pais);	
	//List<Moneda> findByBaseTrue();
	//List<Moneda> findByBaseTrueAndPais(Pais pais);
	
}
