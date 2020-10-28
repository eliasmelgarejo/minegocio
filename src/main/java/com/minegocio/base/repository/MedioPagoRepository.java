package com.minegocio.base.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minegocio.base.domain.MedioPago;
import com.minegocio.base.enums.TipoMedioPago;

public interface MedioPagoRepository extends JpaRepository<MedioPago, Long>{
	
	List<MedioPago> findByNombre(String nombre);
	List<MedioPago> findByTipoMedioPago(TipoMedioPago tipoMedioPago);
}
