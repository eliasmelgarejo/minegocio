package com.minegocio.base.service.dto;

import com.minegocio.base.domain.Departamento;
import com.minegocio.core.BaseDto;

public class CiudadDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Departamento departamento;
	private String nombre;
	
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
