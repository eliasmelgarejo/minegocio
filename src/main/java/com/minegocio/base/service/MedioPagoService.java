package com.minegocio.base.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minegocio.base.domain.MedioPago;
import com.minegocio.base.enums.TipoMedioPago;
import com.minegocio.base.repository.MedioPagoRepository;
import com.minegocio.base.service.dto.MedioPagoDto;
import com.minegocio.core.AbstractService;
import com.minegocio.core.BaseDto;

@Service
@Transactional
public class MedioPagoService extends AbstractService<MedioPago>{


	@Autowired
	private MedioPagoRepository repo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BaseDto convertToDto(MedioPago entity) {
		MedioPagoDto dto = modelMapper.map(entity, MedioPagoDto.class);
		return dto;
	}

	@Override
	public MedioPago convertToEntity(BaseDto dto) {
		MedioPago entity = modelMapper.map((MedioPagoDto)dto, MedioPago.class);
		return entity;
	}

	@Override
	protected JpaRepository<MedioPago, Long> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}
	
	public List<MedioPago> findByNombre(String nombre) {
		return repo.findByNombre(nombre);
	}

	public List<MedioPago> findByTipoMedioPago(TipoMedioPago tipo) {
		return repo.findByTipoMedioPago(tipo);
	}
}
