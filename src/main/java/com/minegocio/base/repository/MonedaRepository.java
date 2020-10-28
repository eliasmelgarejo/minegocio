package com.minegocio.base.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.minegocio.base.domain.Moneda;
import com.minegocio.base.domain.Pais;

public interface MonedaRepository extends JpaRepository<Moneda, Long> {
	
	List<Moneda> findByPais(Pais pais);	
	List<Moneda> findByBaseTrueAndPais(Pais pais);
}
