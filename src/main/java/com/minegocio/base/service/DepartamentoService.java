package com.minegocio.base.service;

import java.util.List;

import com.minegocio.base.domain.Departamento;
import com.minegocio.base.domain.Pais;
import com.minegocio.core.IReadService;
import com.minegocio.core.IWriteService;

public interface DepartamentoService extends IReadService<Departamento>,IWriteService<Departamento>{
	List<Departamento> findByPais(Pais pais);
}
