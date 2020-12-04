package com.minegocio.seguridad.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
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
	@Null
	@ManyToMany(mappedBy = "roles")
	private List<Usuario> usuarios;
	@Null
	@ManyToMany
	@JoinTable
	private List<Permiso> permisos;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}
	
}
