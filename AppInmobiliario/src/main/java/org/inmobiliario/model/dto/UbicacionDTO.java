package org.inmobiliario.model.dto;

import java.io.Serializable;

public class UbicacionDTO implements Serializable {

	private static final long serialVersionUID = -6576122173758448876L;

	private String pais;
	private String estado;
	private String ciudad;
	private String municipio;
	private int codigoPostal;
	private String colonia;
	private String numeroExterior;
	private String numeroInterior;
	private CoordenadasDTO coordenadas;

	public UbicacionDTO() {
		super();
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getNumeroExterior() {
		return numeroExterior;
	}

	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}

	public String getNumeroInterior() {
		return numeroInterior;
	}

	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}

	public CoordenadasDTO getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(CoordenadasDTO coordenadas) {
		this.coordenadas = coordenadas;
	}

	@Override
	public String toString() {
		return "UbicacionDTO [pais=" + pais + ", estado=" + estado + ", ciudad=" + ciudad + ", municipio=" + municipio
				+ ", codigoPostal=" + codigoPostal + ", colonia=" + colonia + ", numeroExterior=" + numeroExterior
				+ ", numeroInterior=" + numeroInterior + ", coordenadas=" + coordenadas + "]";
	}

}
