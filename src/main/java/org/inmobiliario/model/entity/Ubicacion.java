package org.inmobiliario.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ubicacion")
public class Ubicacion {
	@Id
	@Column(name = "id")
	private long id;
	@Column(name = "pais")
	private String pais;
	@Column(name = "estado")
	private String estado;
	@Column(name = "ciudad")
	private String ciudad;
	@Column(name = "municipio")
	private String municipio;
	@Column(name = "codigo_Postal")
	private int codigoPostal;
	@Column(name = "colonia")
	private String colonia;
	@Column(name = "numero_Exterior")
	private String numeroExterior;
	@Column(name = "numero_Interior")
	private String numeroInterior;
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_Coordenadas")
	private Coordenadas coordenadas;

	public Ubicacion() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Coordenadas getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(Coordenadas coordenadas) {
		this.coordenadas = coordenadas;
	}

	@Override
	public String toString() {
		return "Ubicacion [id=" + id + ", pais=" + pais + ", estado=" + estado + ", ciudad=" + ciudad + ", municipio="
				+ municipio + ", codigoPostal=" + codigoPostal + ", colonia=" + colonia + ", numeroExterior="
				+ numeroExterior + ", numeroInterior=" + numeroInterior + ", coordenadas=" + coordenadas + "]";
	}

}
