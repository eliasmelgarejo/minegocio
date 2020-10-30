package com.minegocio.base.service;

import java.util.List;

import com.minegocio.base.domain.Ciudad;
import com.minegocio.base.domain.Departamento;
import com.minegocio.core.IReadService;
import com.minegocio.core.IWriteService;

public interface CiudadService extends IReadService<Ciudad>,IWriteService<Ciudad>{
	List<Ciudad> findByDepartamento(Departamento departamento);
}
