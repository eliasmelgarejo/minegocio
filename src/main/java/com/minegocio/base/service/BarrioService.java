package com.minegocio.base.service;

import java.util.List;

import com.minegocio.base.domain.Barrio;
import com.minegocio.base.domain.Ciudad;

public interface BarrioService extends ReadService<Barrio>,WriteService<Barrio>{
	List<Barrio> findByCiudad(Ciudad ciudad);
}
