package com.minegocio.base.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.minegocio.core.BaseEntity;

import lombok.Data;

@Data
@Entity
@Table(name="infonegocio")
public class InfoNegocio extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String nombre;
	private String contacto;
	private String email;
	private String telefono;
	
	
//	public String getNombre() {
//		return nombre;
//	}
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//	public String getContacto() {
//		return contacto;
//	}
//	public void setContacto(String contacto) {
//		this.contacto = contacto;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getTelefono() {
//		return telefono;
//	}
//	public void setTelefono(String telefono) {
//		this.telefono = telefono;
//	}
	
}
