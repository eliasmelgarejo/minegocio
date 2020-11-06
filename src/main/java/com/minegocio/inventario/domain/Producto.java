package com.minegocio.inventario.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.minegocio.core.BaseEntity;

@Entity
public class Producto extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String codigo;
	@NotNull
	private String codigobarras;
	@NotNull
	@Column(length = 100)
	private String descripcioncorta;
	@NotNull
	@Column(length = 255)
	private String descripcionlarga;
	@Column(columnDefinition = "boolean default false")
	private Boolean perecedero;
	@Column(columnDefinition = "boolean default false")
	private Boolean invetariable;
	@Column(columnDefinition = "boolean default false")
	private Boolean servicio;
	@Column(columnDefinition = "boolean default false")
	private Boolean	tienelote;
	@Null
	@Lob
	private Byte[] image;
	@Null
	@ManyToOne(fetch = FetchType.LAZY)
	private Marca marca;
	@Null
	@ManyToOne(fetch = FetchType.LAZY)
	private Categoria categoria;
	
	
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
