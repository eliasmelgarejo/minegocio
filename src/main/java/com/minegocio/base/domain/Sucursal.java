package com.minegocio.base.domain;

import javax.persistence.ManyToOne;

public class Sucursal {

	private String direccion;
	@ManyToOne
	private Ciudad ciudad;
	@ManyToOne
	private Barrio barrio;
	@ManyToOne
	private InfoNegocio negocio;
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	public Barrio getBarrio() {
		return barrio;
	}
	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}
	public InfoNegocio getNegocio() {
		return negocio;
	}
	public void setNegocio(InfoNegocio negocio) {
		this.negocio = negocio;
	}
	
}
