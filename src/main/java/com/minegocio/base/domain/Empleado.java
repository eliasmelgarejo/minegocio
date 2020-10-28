package com.minegocio.base.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Empleado extends Persona{

	private String codigo;
	private boolean esCajero;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public boolean isEsCajero() {
		return esCajero;
	}
	public void setEsCajero(boolean esCajero) {
		this.esCajero = esCajero;
	}
	
	
}
