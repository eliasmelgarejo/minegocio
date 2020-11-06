package com.minegocio.inventario.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.minegocio.core.BaseEntity;

@Entity
public class Producto extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String codigo;
	@ManyToOne(fetch = FetchType.LAZY)
	private Marca marca;
	@ManyToOne(fetch = FetchType.LAZY)
	private Categoria categoria;
	//others properties
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
