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
	
	
	
	public String getCodigobarras() {
		return codigobarras;
	}
	public void setCodigobarras(String codigobarras) {
		this.codigobarras = codigobarras;
	}
	public String getDescripcioncorta() {
		return descripcioncorta;
	}
	public void setDescripcioncorta(String descripcioncorta) {
		this.descripcioncorta = descripcioncorta;
	}
	public String getDescripcionlarga() {
		return descripcionlarga;
	}
	public void setDescripcionlarga(String descripcionlarga) {
		this.descripcionlarga = descripcionlarga;
	}
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
