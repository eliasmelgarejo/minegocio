package com.minegocio.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minegocio.base.domain.MedioPago;
import com.minegocio.base.enums.TipoMedioPago;
import com.minegocio.base.repository.MedioPagoRepository;
import com.minegocio.base.service.MedioPagoService;

@Service
@Transactional
public class MedioPagoServiceImpl implements MedioPagoService{

	@Autowired
	private MedioPagoRepository repo;

	@Override
	public MedioPago findById(Long id) {
		return repo.getOne(id);
	}

	@Override
	public List<MedioPago> findAll() {
		return repo.findAll();
	}


	@Override
	public MedioPago save(MedioPago entity) {
		return (repo.save(entity));
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Object convertToDto(MedioPago t) {
		
		return null;
	}
	
	@Override
	public MedioPago convertToEntity(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MedioPago> findByNombre(String nombre) {
		return repo.findByNombre(nombre);
	}

	@Override
	public List<MedioPago> findByTipoMedioPago(TipoMedioPago tipo) {
		return repo.findByTipoMedioPago(tipo);
	}
			
	
}
