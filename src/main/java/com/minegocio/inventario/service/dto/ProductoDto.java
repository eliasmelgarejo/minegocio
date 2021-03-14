package com.minegocio.inventario.service.dto;

import com.minegocio.core.BaseDto;
import com.minegocio.inventario.domain.Categoria;
import com.minegocio.inventario.domain.Marca;

public class ProductoDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String codigobarras;
	private String descripcioncorta;
	private String descripcionlarga;
	private Boolean perecedero;
	private Boolean inventariable;
	private Boolean servicio;
	private Boolean	tienelote;
	private Byte[] image;
	private Marca marca;
	private Categoria categoria;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
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
	public Byte[] getImage() {
		return image;
	}
	public void setImage(Byte[] image) {
		this.image = image;
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
