package com.minegocio.base.service.dto;

import com.minegocio.core.BaseDto;

public class EmpleadoDto extends BaseDto {

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
	public void setCajero(boolean cajero) {
		this.cajero = cajero;
	}

}
