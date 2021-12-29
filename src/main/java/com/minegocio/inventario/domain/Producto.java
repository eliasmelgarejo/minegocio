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
	
	
	private String codigo;
	
	private String codigobarras;
	
	@Column(length = 100)
	private String descripcioncorta;
	
	@Column(length = 255)
	private String descripcionlarga;
	@Column(columnDefinition = "boolean default false")
	private Boolean perecedero;
	@Column(columnDefinition = "boolean default false")
	private Boolean inventariable;
	@Column(columnDefinition = "boolean default false")
	private Boolean servicio;
	@Column(columnDefinition = "boolean default false")
	private Boolean	tienelote;
	@Lob
	private Byte[] image;
	@ManyToOne(fetch = FetchType.LAZY)
	private Marca marca;
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
	public Boolean getPerecedero() {
		return perecedero;
	}
	public void setPerecedero(Boolean perecedero) {
		this.perecedero = perecedero;
	}
	public Boolean getInventariable() {
		return inventariable;
	}
	public void setInventariable(Boolean inventariable) {
		this.inventariable = inventariable;
	}
	public Boolean getServicio() {
		return servicio;
	}
	public void setServicio(Boolean servicio) {
		this.servicio = servicio;
	}
	public Boolean getTienelote() {
		return tienelote;
	}
	public void setTienelote(Boolean tienelote) {
		this.tienelote = tienelote;
	}
	
}
