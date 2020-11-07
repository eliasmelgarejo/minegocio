package com.minegocio.base.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minegocio.base.domain.MedioPago;
import com.minegocio.base.enums.TipoMedioPago;
import com.minegocio.base.repository.MedioPagoRepository;
import com.minegocio.base.service.MedioPagoService;
import com.minegocio.base.service.dto.MedioPagoDto;

@Service
@Transactional
public class MedioPagoServiceImpl implements MedioPagoService{

	@Autowired
	private MedioPagoRepository repo;
	
	@Autowired
	ModelMapper modelMapper;

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
	public MedioPagoDto convertToDto(MedioPago entity) {
		MedioPagoDto dto = modelMapper.map(entity, MedioPagoDto.class);
		return dto;
	}
	
	@Override
	public MedioPago convertToEntity(Object dto) {
		MedioPago entity = modelMapper.map((MedioPagoDto)dto, MedioPago.class);
		return entity;
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
