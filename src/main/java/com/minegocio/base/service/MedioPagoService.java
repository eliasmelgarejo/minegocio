package com.minegocio.base.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minegocio.base.domain.MedioPago;
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
	public MedioPagoDto convertToDto(MedioPago medioPago) {
		// TODO Auto-generated method stub
		MedioPagoDto dto = modelMapper.map(medioPago, MedioPagoDto.class);
		return dto;
	}

	@Override
	public MedioPago convertToEntity(BaseDto dto) {
		// TODO Auto-generated method stub
		MedioPago medioPago = modelMapper.map((MedioPagoDto)dto, MedioPago.class);
		return medioPago;
	}

	@Override
	protected JpaRepository<MedioPago, Long> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}
	
	
}