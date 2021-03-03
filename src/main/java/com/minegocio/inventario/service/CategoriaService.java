package com.minegocio.inventario.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minegocio.core.AbstractService;
import com.minegocio.core.BaseDto;
import com.minegocio.inventario.domain.Categoria;
import com.minegocio.inventario.repository.CategoriaRepository;
import com.minegocio.inventario.service.dto.CategoriaDto;

@Service
@Transactional
public class CategoriaService  extends AbstractService<Categoria>{
	
	@Autowired
	private CategoriaRepository repo;
	
	@Autowired
    private ModelMapper modelMapper;

	@Override
	public CategoriaDto convertToDto(Categoria categoria) {
		// TODO Auto-generated method stub
		CategoriaDto dto = modelMapper.map(categoria, CategoriaDto.class);
		return dto;
	}

	@Override
	public Categoria convertToEntity(BaseDto dto) {
		// TODO Auto-generated method stub
		Categoria categoria = modelMapper.map((CategoriaDto)dto, Categoria.class);
		return categoria;
	}

	@Override
	protected JpaRepository<Categoria, Long> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}
	
	// custom method
	public Categoria findByNombre(String nombre) {
		Categoria categoria;
		try {
			categoria = repo.findByNombre(nombre);
		} catch (Exception e) {
			categoria= null;
		}
		return categoria;
	}
}
