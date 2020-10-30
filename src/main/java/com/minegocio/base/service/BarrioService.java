package com.minegocio.base.service;

import java.util.List;

import com.minegocio.base.domain.Barrio;
import com.minegocio.base.domain.Ciudad;
import com.minegocio.core.IReadService;
import com.minegocio.core.IWriteService;

public interface BarrioService extends IReadService<Barrio>,IWriteService<Barrio>{
	List<Barrio> findByCiudad(Ciudad ciudad);
}
