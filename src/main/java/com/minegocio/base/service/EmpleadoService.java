package com.minegocio.base.service;

import com.minegocio.base.domain.Empleado;

public interface EmpleadoService extends ReadService<Empleado>,WriteService<Empleado>{
	Empleado findByDocumento(String documento);
}
