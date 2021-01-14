package com.minegocio.base.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.minegocio.base.enums.TipoMedioPago;
import com.minegocio.core.BaseEntity;

@Entity
public class MedioPago extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	@Enumerated(EnumType.STRING)
	private TipoMedioPago tipoMedioPago;
	private boolean depositable;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public TipoMedioPago getTipoMedioPago() {
		return tipoMedioPago;
	}
	public void setTipoMedioPago(TipoMedioPago tipoMedioPago) {
		this.tipoMedioPago = tipoMedioPago;
	}
	public boolean isDepositable() {
		return depositable;
	}
	public void setDepositable(boolean depositable) {
		this.depositable = depositable;
	}
	
}
