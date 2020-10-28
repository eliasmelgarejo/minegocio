package com.minegocio.base.service;

import java.util.List;

import com.minegocio.base.domain.MedioPago;
import com.minegocio.base.enums.TipoMedioPago;

public interface MedioPagoService extends ReadService<MedioPago>,WriteService<MedioPago>{

	List<MedioPago> findByNombre(String nombre);
	List<MedioPago> findByTipoMedioPago(TipoMedioPago tipo);
}
