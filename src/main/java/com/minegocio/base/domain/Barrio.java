package com.minegocio.base.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Barrio extends BaseEntity{

	private String nombre;
	@ManyToOne
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
