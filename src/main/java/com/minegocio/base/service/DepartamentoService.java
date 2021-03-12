package com.minegocio.base.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minegocio.base.domain.Departamento;
import com.minegocio.base.domain.Pais;
import com.minegocio.base.repository.DepartamentoRepository;
import com.minegocio.base.service.dto.DepartamentoDto;
import com.minegocio.core.AbstractService;
import com.minegocio.core.BaseDto;

@Service
@Transactional
public class DepartamentoService extends AbstractService<Departamento>{
	
	@Autowired
	private DepartamentoRepository repo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public DepartamentoDto convertToDto(Departamento entity) {
		DepartamentoDto dto = modelMapper.map(entity, DepartamentoDto.class);
		return dto;
	}

	@Override
	public Departamento convertToEntity(BaseDto dto) {
		Departamento entity = modelMapper.map((DepartamentoDto)dto, Departamento.class);
		return entity;
	}

	@Override
	protected JpaRepository<Departamento, Long> getRepo() {
		return this.repo;
	}
	
	
	//custom
	public List<Departamento> findByPais(Pais pais){
		List<Departamento> list;
		try {
			list = repo.findByPais(pais);
		} catch (Exception e) {
			list = null;
		}
		
		return list;
	}
	
	public Departamento findByNombre(String nombre) {
		Departamento departamento;
		try {
			departamento = repo.findByNombre(nombre);
		} catch (Exception e) {
			departamento = null;
		}
		return departamento;
	}
	
	
}
