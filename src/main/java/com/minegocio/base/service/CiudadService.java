package com.minegocio.base.service;

import java.util.List;

import com.minegocio.base.domain.Ciudad;
import com.minegocio.base.domain.Departamento;

public interface CiudadService extends ReadService<Ciudad>,WriteService<Ciudad>{
	List<Ciudad> findByDepartamento(Departamento departamento);
}
