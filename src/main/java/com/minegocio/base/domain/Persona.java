package com.minegocio.base.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.minegocio.base.enums.EstadoCivil;
import com.minegocio.base.enums.TipoDocumento;


@Entity
@Table(name="persona")
public class Persona extends BaseEntity {
	
	@Enumerated(EnumType.STRING)
	private TipoDocumento tipoDocumento;
	@NotNull
	@Column(unique=true)
	private String documento;
	@NotNull
	private String nombres;
	@NotNull
	private String apellidos;
	@Null
	private String direccion;
	@Null
	private String telefono;
	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivil;
	private boolean esEmpleado;
	private boolean esCliente;
	private boolean esProveedor;
	
	
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public boolean isEsEmpleado() {
		return esEmpleado;
	}
	public void setEsEmpleado(boolean esEmpleado) {
		this.esEmpleado = esEmpleado;
	}
	public boolean isEsCliente() {
		return esCliente;
	}
	public void setEsCliente(boolean esCliente) {
		this.esCliente = esCliente;
	}
	public boolean isEsProveedor() {
		return esProveedor;
	}
	public void setEsProveedor(boolean esProveedor) {
		this.esProveedor = esProveedor;
	}
	
}
