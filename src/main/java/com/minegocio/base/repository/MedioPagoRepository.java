package com.minegocio.base.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minegocio.base.domain.MedioPago;
import com.minegocio.base.enums.TipoMedioPago;

@Repository
public interface MedioPagoRepository extends JpaRepository<MedioPago, Long>{
	
	List<MedioPago> findByNombre(String nombre);
	List<MedioPago> findByTipoMedioPago(TipoMedioPago tipoMedioPago);
}
