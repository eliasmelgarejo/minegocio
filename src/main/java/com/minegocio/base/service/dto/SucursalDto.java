package com.minegocio.base.service.dto;

import com.minegocio.base.domain.Barrio;
import com.minegocio.base.domain.Ciudad;
import com.minegocio.base.domain.InfoNegocio;
import com.minegocio.core.BaseDto;

public class SucursalDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Barrio barrio;
	private Ciudad ciudad;
	private String direccion;
	private InfoNegocio negocio;
	
	public Barrio getBarrio() {
		return barrio;
	}
	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public InfoNegocio getNegocio() {
		return negocio;
	}
	public void setNegocio(InfoNegocio negocio) {
		this.negocio = negocio;
	}

}
