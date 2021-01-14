package com.minegocio.base.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minegocio.base.domain.Moneda;
import com.minegocio.base.domain.Pais;
import com.minegocio.base.repository.MonedaRepository;
import com.minegocio.base.service.dto.MonedaDto;
import com.minegocio.core.AbstractService;
import com.minegocio.core.BaseDto;

@Service
@Transactional
public class MonedaService extends AbstractService<Moneda>{
	
	@Autowired
	private MonedaRepository repo;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public BaseDto convertToDto(Moneda entity) {
		MonedaDto dto = modelMapper.map(entity, MonedaDto.class);
		return dto;
	}

	@Override
	public Moneda convertToEntity(BaseDto dto) {
		Moneda entity = modelMapper.map((MonedaDto)dto, Moneda.class);
		return entity;
	}

	@Override
	protected JpaRepository<Moneda, Long> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}
	
	public List<Moneda> findByPais(Pais pais) {
		return repo.findByPais(pais);
	}

	public List<Moneda> findByBaseTrue() {
		return repo.findByBaseTrue();
	}
			
	public List<Moneda> findByBaseTrueAndPais(Pais pais) {
		return repo.findByBaseTrueAndPais(pais);
	}

}
