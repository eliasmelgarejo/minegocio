package com.minegocio.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minegocio.base.domain.Barrio;
import com.minegocio.base.domain.Ciudad;
import com.minegocio.base.repository.BarrioRepository;
import com.minegocio.base.service.BarrioService;

@Service
@Transactional
public class BarrioServiceImpl implements BarrioService{

	@Autowired
	private BarrioRepository repo;
	
	@Override
	public Barrio findById(Long id) {
		Barrio barrio = repo.getOne(id); 
		return barrio;
	}

	@Override
	public List<Barrio> findAll() {
		return repo.findAll();
	}

	@Override
	public Barrio save(Barrio entity) {
		return repo.save(entity);
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}

	@Override
	public List<Barrio> findByCiudad(Ciudad ciudad) {
		return repo.findByCiudad(ciudad);
	}

}
