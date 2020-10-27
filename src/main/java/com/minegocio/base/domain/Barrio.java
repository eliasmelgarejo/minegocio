package com.minegocio.base.domain;

import javax.persistence.Entity;

@Entity
public class Barrio extends BaseEntity{

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
