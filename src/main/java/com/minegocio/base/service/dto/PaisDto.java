package com.minegocio.base.service.dto;

import com.minegocio.core.BaseDto;

import lombok.Builder;
import lombok.Data;

@Data @Builder(toBuilder = true)
public class PaisDto extends BaseDto {

	/**
	 * 
	 */
	
	
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String gentilicio;
	
}
