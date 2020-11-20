package com.minegocio.base.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minegocio.base.domain.Barrio;
import com.minegocio.base.domain.Ciudad;
import com.minegocio.base.repository.BarrioRepository;
import com.minegocio.base.service.dto.BarrioDto;
import com.minegocio.core.AbstractService;
import com.minegocio.core.BaseDto;

@Service
@Transactional
public class BarrioService extends AbstractService<Barrio> {

	@Autowired
	private BarrioRepository repo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BarrioDto convertToDto(Barrio t) {
		BarrioDto dto = modelMapper.map(t, BarrioDto.class);
		return dto;
	}

	@Override
	public Barrio convertToEntity(BaseDto dto) {
		Barrio entity = modelMapper.map((BarrioDto) dto, Barrio.class);
		return entity;
	}

	@Override
	protected JpaRepository<Barrio, Long> getRepo() {
		return this.repo;
	}

	public List<Barrio> findByCiudad(Ciudad ciudad) {
		List<Barrio> list;
		try {
			list = repo.findByCiudad(ciudad);
		} catch (Exception e) {
			list = null;
		}
		return list;
	}

}
