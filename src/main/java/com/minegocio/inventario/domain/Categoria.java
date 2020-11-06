package com.minegocio.inventario.domain;

import javax.persistence.Entity;
import javax.persistence.Lob;

import com.minegocio.core.BaseEntity;

@Entity
public class Categoria extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	@Lob
	private Byte[] image;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Byte[] getImage() {
		return image;
	}

	public void setImage(Byte[] image) {
		this.image = image;
	}
}
