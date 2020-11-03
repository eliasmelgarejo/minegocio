package com.minegocio.base.service.dto;

import com.minegocio.base.domain.Ciudad;
import com.minegocio.core.BaseDto;

public class BarrioDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombre;
	private Ciudad ciudad;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
}
