package com.minegocio.base.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.minegocio.core.BaseEntity;

@Entity
public class Departamento extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	@ManyToOne
	private Pais pais;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	
}
