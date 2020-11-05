package com.minegocio.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minegocio.base.domain.Sucursal;
import com.minegocio.base.repository.SucursalRepository;
import com.minegocio.base.service.SucursalService;

@Service
@Transactional
public class SucursalServiceImpl implements SucursalService{

	@Autowired
	private SucursalRepository repo;

	@Override
	public Sucursal findById(Long id) {
		return repo.getOne(id);
	}

	@Override
	public List<Sucursal> findAll() {
		return repo.findAll();
	}


	@Override
	public Sucursal save(Sucursal entity) {
		return (repo.save(entity));
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Object convertToDto(Sucursal t) {
		
		return null;
	}
	
	@Override
	public Sucursal convertToEntity(Object o) {
		// TODO Auto-generated method stub
		return null;
	}
			
	
}
