package org.inmobiliario.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Inmueble")
public class Inmueble {

	@Id
	@Column(name = "id")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(name = "tipo_Inmueble")
	private String tipoInmueble;
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_Ubicacion")
	private Ubicacion ubicacion;
	@Column(name = "estatus_Inmueble")
	private String estatusInmueble;
	@Column(name = "largo")
	private double largo;
	@Column(name = "ancho")
	private double ancho;
	@Column(name = "precio_X_Metro_Cuadrado")
	private String precioXMetroCuadrado;

	public Inmueble() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipoInmueble() {
		return tipoInmueble;
	}

	public void setTipoInmueble(String tipoInmueble) {
		this.tipoInmueble = tipoInmueble;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getEstatusInmueble() {
		return estatusInmueble;
	}

	public void setEstatusInmueble(String estatusInmueble) {
		this.estatusInmueble = estatusInmueble;
	}

	public double getLargo() {
		return largo;
	}

	public void setLargo(double largo) {
		this.largo = largo;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public String getPrecioXMetroCuadrado() {
		return precioXMetroCuadrado;
	}

	public void setPrecioXMetroCuadrado(String precioXMetroCuadrado) {
		this.precioXMetroCuadrado = precioXMetroCuadrado;
	}

	@Override
	public String toString() {
		return "Inmueble [id=" + id + ", tipoInmueble=" + tipoInmueble + ", ubicacion=" + ubicacion
				+ ", estatusInmueble=" + estatusInmueble + ", largo=" + largo + ", ancho=" + ancho
				+ ", precioXMetroCuadrado=" + precioXMetroCuadrado + "]";
	}

}
