package com.minegocio.inventario.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minegocio.inventario.domain.Marca;
import com.minegocio.inventario.repository.MarcaRepository;
import com.minegocio.inventario.service.MarcaService;
import com.minegocio.inventario.service.dto.MarcaDto;

@Service
@Transactional
public class MarcaServiceImpl implements MarcaService{

	@Autowired
	private MarcaRepository repo;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public Marca save(Marca entity) {
		return (repo.save(entity));
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Marca findById(Long id) {
		return repo.getOne(id);
	}

	@Override
	public List<Marca> findAll() {
		return repo.findAll();
	}

	@Override
	public MarcaDto convertToDto(Marca entity) {
		MarcaDto dto = modelMapper.map(entity, MarcaDto.class);
		return dto;
	}

	@Override
	public Marca convertToEntity(Object dto) {
		Marca entity = modelMapper.map(dto, Marca.class);
		return entity;
	}
	

}
