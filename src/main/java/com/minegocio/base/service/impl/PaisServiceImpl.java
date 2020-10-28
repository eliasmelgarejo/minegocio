package com.minegocio.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minegocio.base.domain.Pais;
import com.minegocio.base.repository.PaisRepository;
import com.minegocio.base.service.PaisService;

@Service
@Transactional
public class PaisServiceImpl implements PaisService{

	@Autowired
	private PaisRepository repo;
	
	@Override
	public Pais findById(Long id) {
		return repo.getOne(id);
	}

	@Override
	public List<Pais> findAll() {
		return repo.findAll();
	}

	@Override
	public Pais save(Pais entity) {
		return repo.save(entity);
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);		
	}

}