package com.minegocio.base.service;

import java.util.List;

import com.minegocio.base.domain.MedioPago;
import com.minegocio.base.enums.TipoMedioPago;
import com.minegocio.core.IReadService;
import com.minegocio.core.IWriteService;

public interface MedioPagoService extends IReadService<MedioPago>,IWriteService<MedioPago>{

	List<MedioPago> findByNombre(String nombre);
	List<MedioPago> findByTipoMedioPago(TipoMedioPago tipo);
}
