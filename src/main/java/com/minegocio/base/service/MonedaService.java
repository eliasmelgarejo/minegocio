/*
 * package com.minegocio.base.service;
 * 
 * import java.util.List;
 * 
 * import com.minegocio.base.domain.Moneda; import
 * com.minegocio.base.domain.Pais; import com.minegocio.core.IReadService;
 * import com.minegocio.core.IWriteService;
 * 
 * public interface MonedaService extends
 * IReadService<Moneda>,IWriteService<Moneda>{
 * 
 * List<Moneda> findByPais(Pais pais); List<Moneda> findByBaseTrue();
 * List<Moneda> findByBaseTrueAndPais(Pais pais); }
 */




package com.minegocio.base.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minegocio.base.domain.Moneda;
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
	public MonedaDto convertToDto(Moneda moneda) {
		//
		MonedaDto dto = modelMapper.map(moneda, MonedaDto.class);
		return dto;
	}

	@Override
	public Moneda convertToEntity(BaseDto dto) {
		// 
		Moneda moneda = modelMapper.map((MonedaDto)dto, Moneda.class);
		return moneda;
	}

	@Override
	protected JpaRepository<Moneda, Long> getRepo() {
		// 
		return repo;
	}
	
}