package com.minegocio.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minegocio.base.domain.Empleado;
import com.minegocio.base.repository.EmpleadoRepository;
import com.minegocio.base.service.EmpleadoService;

@Service
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService{

	@Autowired
	private EmpleadoRepository repo;

	@Override
	public Empleado findById(Long id) {
		return repo.getOne(id);
	}

	@Override
	public List<Empleado> findAll() {
		return repo.findAll();
	}


	@Override
	public Empleado save(Empleado entity) {
		return (repo.save(entity));
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Object convertToDto(Empleado t) {
		
		return null;
	}
	
	@Override
	public Empleado convertToEntity(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado findByDocumento(String documento) {
		return repo.findByDocumento(documento);
	}
			
	
}
