package com.minegocio.seguridad.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Null;

import com.minegocio.core.BaseEntity;

@Entity
public class Rol extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6842499439980052834L;
	
	private String nombre;
//	@Null
//	@ManyToMany(mappedBy = "user")
//	private List<Usuario> usuarios;
// 
//	public List<Usuario> getUsuarios() {
//		return usuarios;
//	}
//
//	public void setUsuarios(List<Usuario> usuarios) {
//		this.usuarios = usuarios;
//	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
