package com.minegocio.inventario.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minegocio.inventario.domain.Deposito;
import com.minegocio.inventario.repository.DepositoRepository;
import com.minegocio.inventario.service.dto.DepositoDto;
import com.minegocio.core.AbstractService;
import com.minegocio.core.BaseDto;

@Service
@Transactional
public class DepositoService extends AbstractService<Deposito>{
	
	@Autowired
	private DepositoRepository repo;
	
	@Autowired
    private ModelMapper modelMapper;

	@Override
	public DepositoDto convertToDto(Deposito deposito) {
		// TODO Auto-generated method stub
		DepositoDto dto = modelMapper.map(deposito, DepositoDto.class);
		return dto;
	}

	@Override
	public Deposito convertToEntity(BaseDto dto) {
		// TODO Auto-generated method stub
		Deposito deposito = modelMapper.map((DepositoDto)dto, Deposito.class);
		return deposito;
	}

	@Override
	protected JpaRepository<Deposito, Long> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

}
