package com.backend.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipomoneda")
public class tipoMoneda implements Serializable {
	
	
	//CODIGO DEL TIPO MONEDA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//DESCRIPCION DE LA MONEDA DE CAMBIO
	@Column(name = "descambio")
	private String desCambio;
	
	//VALOR DE LA MONEDA DE CAMBIO
	@Column(name = "tipocambio")
	private Float tipoCambio;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDesCambio() {
		return desCambio;
	}
	public void setDesCambio(String desCambio) {
		this.desCambio = desCambio;
	}
	public Float getTipoCambio() {
		return tipoCambio;
	}
	public void setTipoCambio(Float tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
