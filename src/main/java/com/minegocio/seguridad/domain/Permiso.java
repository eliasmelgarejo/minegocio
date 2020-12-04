package com.minegocio.seguridad.domain;

import javax.persistence.Entity;

import com.minegocio.core.BaseEntity;

@Entity
public class Permiso extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5173309859329490470L;
	
	private String nombre;
	private String modulo;
	private String url;
	private boolean accion;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getModulo() {
		return modulo;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isAccion() {
		return accion;
	}
	public void setAccion(boolean accion) {
		this.accion = accion;
	}
}
