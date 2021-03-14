package com.minegocio.base.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.minegocio.core.BaseEntity;

@Entity
public class Sucursal extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String direccion;
	@ManyToOne
	private Ciudad ciudad;
	@ManyToOne
	private Barrio barrio;
	@ManyToOne
	private InfoNegocio infoNegocio;
	
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
	public InfoNegocio getInfoNegocio() {
		return infoNegocio;
	}
	public void setInfoNegocio(InfoNegocio infoNegocio) {
		this.infoNegocio = infoNegocio;
	}
	
	
}
