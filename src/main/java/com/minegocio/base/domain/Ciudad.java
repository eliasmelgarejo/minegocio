package com.minegocio.base.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Ciudad extends BaseEntity{

	private String nombre;
	@ManyToOne
	private Departamento departamento;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
}
