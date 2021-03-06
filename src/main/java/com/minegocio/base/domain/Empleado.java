package com.minegocio.base.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Empleado extends Persona{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private boolean cajero;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public boolean isCajero() {
		return cajero;
	}
	public void setCajero(boolean esCajero) {
		this.cajero = esCajero;
	}
	
	
}
