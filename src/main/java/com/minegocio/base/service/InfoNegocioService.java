package com.minegocio.base.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minegocio.base.domain.InfoNegocio;
import com.minegocio.base.repository.InfoNegocioRepository;
import com.minegocio.base.service.dto.InfoNegocioDto;
import com.minegocio.core.AbstractService;
import com.minegocio.core.BaseDto;

@Service
@Transactional
public class InfoNegocioService extends AbstractService<InfoNegocio> {

	@Autowired
	private InfoNegocioRepository repo;
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	
	public BaseDto convertToDto(InfoNegocio entity) {
		InfoNegocioDto dto = modelMapper.map(entity, InfoNegocioDto.class);
		return dto;
	}
	@Override
	public InfoNegocio convertToEntity(BaseDto dto) {
		InfoNegocio entity = modelMapper.map((InfoNegocioDto)dto, InfoNegocio.class);
		return entity;
	}
	@Override
	protected JpaRepository<InfoNegocio, Long> getRepo() {
		return repo;
	}
	
	//custom method
	public InfoNegocio findByNombre(String nombre) {
		InfoNegocio negocio;
		try {
			negocio = repo.findByNombre(nombre);
		} catch (Exception e) {
			negocio= null;
		}
		return negocio;
	}
}
