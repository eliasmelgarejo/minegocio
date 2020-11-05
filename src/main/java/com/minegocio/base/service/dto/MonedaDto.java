package com.minegocio.base.service.dto;

import com.minegocio.base.domain.Pais;
import com.minegocio.core.BaseDto;

public class MonedaDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean base;
	private Pais pais;
	private String simbolo;
	
	public boolean isBase() {
		return base;
	}
	public void setBase(boolean base) {
		this.base = base;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public String getSimbolo() {
		return simbolo;
	}
	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	
}
