package org.inmobiliario.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Coordenadas")
public class Coordenadas {

	@Id
	@Column(name = "id")
	private long id;
	@Column(name = "latitud")
	private double latitud;
	@Column(name = "longitud")
	private double longitud;

	public Coordenadas() {
		super();
	}

	public Coordenadas(double latitudParam, double longitudParam) {
		super();
		this.latitud = latitudParam;
		this.longitud = longitudParam;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return "Coordenadas [id=" + id + ", latitud=" + latitud + ", longitud=" + longitud + "]";
	}

}
