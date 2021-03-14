package com.minegocio.inventario.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minegocio.inventario.domain.Producto;
import com.minegocio.inventario.repository.ProductoRepository;
import com.minegocio.inventario.service.dto.ProductoDto;
import com.minegocio.core.AbstractService;
import com.minegocio.core.BaseDto;

@Service
@Transactional
public class ProductoService extends AbstractService<Producto> {
	
	@Autowired
	private ProductoRepository repo;
	
	@Autowired
    private ModelMapper modelMapper;
	
	
	@Override
	public ProductoDto convertToDto(Producto producto) {
		ProductoDto dto = modelMapper.map(producto, ProductoDto.class);
		return dto;
	}
	
	@Override
	public Producto convertToEntity(BaseDto dto) {
		Producto producto = modelMapper.map((ProductoDto)dto, Producto.class);
		return producto;
	}
	
	
	@Override
	protected JpaRepository<Producto, Long> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}
	
	// custom method
	//Como no tengo el campo "nombre" uso el campo "codigo" como campo de busqueda
	public Producto findByCodigo(String codigo) {
		Producto producto;
		try {
			producto = repo.findByCodigo(codigo);
		} catch (Exception e) {
			producto = null;
		}
		
		return producto;
	}
	
}
