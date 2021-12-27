package com.minegocio.base.domain;

import javax.persistence.Entity;

import com.minegocio.core.BaseEntity;

import lombok.Data;

@Data
@Entity
public class Pais extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String gentilicio;
	
	
}
