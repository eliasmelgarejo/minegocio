package com.minegocio.inventario.service.dto;

import com.minegocio.core.BaseDto;

public class DepositoDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private int sucursal_id;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getSucursal_id() {
		return sucursal_id;
	}
	public void setSucursal_id(int sucursal_id) {
		this.sucursal_id = sucursal_id;
	}
	
	
}
