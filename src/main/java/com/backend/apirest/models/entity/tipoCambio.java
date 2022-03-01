package com.backend.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipocambio")
public class tipoCambio implements Serializable {
	
	//CODIGO DEL TIPO DE CAMBIO
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//INGRESO DEL MONTO INICIAL
	@Column
	private Float monto;
	
	//DEVUELVE EL VALOR DEL MONTO CAMBIADO AL VALOR DE LA MONEDA
	@Column
	private Float montoCambio;
	
	//CADENA DE MONEDA DE ORIGEN  soles / dolar / euro
	@Column
	private String monedaOrigen;
	
	//CADENA DE MONEDA DE DESTINO  soles / dolar / euro
	@Column
	private String monedaDestino;
	
	//TIPO DE CAMBIO  soles / dolar / euro
	@Column
	private Float tipoCambio;
	
	public Float getMonto() {
		return monto;
	}
	public void setMonto(Float monto) {
		this.monto = monto;
	}
	public Float getMontoCambio() {
		return montoCambio;
	}
	public void setMontoCambio(Float montoCambio) {
		this.montoCambio = montoCambio;
	}
	public String getMonedaOrigen() {
		return monedaOrigen;
	}
	public void setMonedaOrigen(String monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}
	public String getMonedaDestino() {
		return monedaDestino;
	}
	public void setMonedaDestino(String monedaDestino) {
		this.monedaDestino = monedaDestino;
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
