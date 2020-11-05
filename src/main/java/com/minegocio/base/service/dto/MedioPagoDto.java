package com.minegocio.base.service.dto;

import com.minegocio.base.enums.TipoMedioPago;
import com.minegocio.core.BaseDto;

public class MedioPagoDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean depositable;
	private String nombre;
	private TipoMedioPago tipoMedioPago;

	public boolean isDepositable() {
		return depositable;
	}
	public void setDepositable(boolean depositable) {
		this.depositable = depositable;
	}
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

}
