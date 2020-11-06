package com.minegocio.inventario.domain;

import javax.persistence.Entity;

import com.minegocio.core.BaseEntity;

@Entity
public class Marca extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
