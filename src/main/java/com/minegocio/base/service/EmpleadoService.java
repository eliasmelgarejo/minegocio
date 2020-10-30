package com.minegocio.base.service;

import com.minegocio.base.domain.Empleado;
import com.minegocio.core.IReadService;
import com.minegocio.core.IWriteService;

public interface EmpleadoService extends IReadService<Empleado>,IWriteService<Empleado>{
	Empleado findByDocumento(String documento);
}
