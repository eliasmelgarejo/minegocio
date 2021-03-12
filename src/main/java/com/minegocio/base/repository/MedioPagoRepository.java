package com.minegocio.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minegocio.base.domain.MedioPago;

@Repository
public interface MedioPagoRepository extends JpaRepository<MedioPago, Long>{
	MedioPago findByNombre(String nombre);
	
	//ESTE CODIGO NO ESTABA COMENTADO ORIGINALMENTE
	//List<MedioPago> findByNombre(String nombre);
	//List<MedioPago> findByTipoMedioPago(TipoMedioPago tipoMedioPago);
}
