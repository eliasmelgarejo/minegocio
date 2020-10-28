package com.minegocio.base.service;

import java.util.List;

import com.minegocio.base.domain.Moneda;
import com.minegocio.base.domain.Pais;

public interface MonedaService extends ReadService<Moneda>,WriteService<Moneda>{
	
	List<Moneda> findByPais(Pais pais);
	List<Moneda> findByBaseTrue();
}
