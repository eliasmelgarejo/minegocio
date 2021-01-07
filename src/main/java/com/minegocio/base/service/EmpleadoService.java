/*
 * package com.minegocio.base.service;
 * 
 * import com.minegocio.base.domain.Empleado; import
 * com.minegocio.core.IReadService; import com.minegocio.core.IWriteService;
 * 
 * public interface EmpleadoService extends
 * IReadService<Empleado>,IWriteService<Empleado>{ Empleado
 * findByDocumento(String documento); }
 */









package com.minegocio.base.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minegocio.base.domain.Empleado;
import com.minegocio.base.domain.Pais;
import com.minegocio.base.repository.EmpleadoRepository;
import com.minegocio.base.repository.PaisRepository;
import com.minegocio.base.service.dto.EmpleadoDto;
import com.minegocio.base.service.dto.PaisDto;
import com.minegocio.core.AbstractService;
import com.minegocio.core.BaseDto;

@Service
@Transactional
public class EmpleadoService extends AbstractService<Empleado>{
	
	@Autowired
	private EmpleadoRepository repo;
	
	@Autowired
    private ModelMapper modelMapper;

	@Override
	public EmpleadoDto convertToDto(Empleado empleado) {
		// TODO Auto-generated method stub
		EmpleadoDto dto = modelMapper.map(empleado, EmpleadoDto.class);
		return dto;
	}

	@Override
	public Empleado convertToEntity(BaseDto dto) {
		// TODO Auto-generated method stub
		Empleado empleado = modelMapper.map((EmpleadoDto)dto, Empleado.class);
		return empleado;
	}

	@Override
	protected JpaRepository<Empleado, Long> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}
	
	
	
}