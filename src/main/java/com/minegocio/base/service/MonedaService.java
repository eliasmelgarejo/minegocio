package com.minegocio.base.service;

import java.util.List;

import com.minegocio.base.domain.Moneda;
import com.minegocio.base.domain.Pais;
import com.minegocio.core.IReadService;
import com.minegocio.core.IWriteService;

public interface MonedaService extends IReadService<Moneda>,IWriteService<Moneda>{
	
	List<Moneda> findByPais(Pais pais);
	List<Moneda> findByBaseTrue();
	List<Moneda> findByBaseTrueAndPais(Pais pais);
}
