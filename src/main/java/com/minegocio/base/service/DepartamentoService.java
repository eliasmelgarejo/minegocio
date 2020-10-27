package com.minegocio.base.service;

import java.util.List;

import com.minegocio.base.domain.Departamento;
import com.minegocio.base.domain.Pais;

public interface DepartamentoService extends ReadService<Departamento>,WriteService<Departamento>{
	List<Departamento> findByPais(Pais pais);
}
