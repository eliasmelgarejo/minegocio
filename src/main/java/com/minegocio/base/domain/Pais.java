package com.minegocio.base.domain;

import javax.persistence.Entity;

@Entity
public class Pais extends BaseEntity {

	private String nombre;
	private String gentilicio;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGentilicio() {
		return gentilicio;
	}
	public void setGentilicio(String gentilicio) {
		this.gentilicio = gentilicio;
	}
	
	
}
