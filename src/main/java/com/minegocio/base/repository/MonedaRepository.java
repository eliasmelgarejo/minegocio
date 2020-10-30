package com.minegocio.base.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minegocio.base.domain.Moneda;
import com.minegocio.base.domain.Pais;

@Repository
public interface MonedaRepository extends JpaRepository<Moneda, Long> {
	
	List<Moneda> findByPais(Pais pais);	
	List<Moneda> findByBaseTrueAndPais(Pais pais);
}
