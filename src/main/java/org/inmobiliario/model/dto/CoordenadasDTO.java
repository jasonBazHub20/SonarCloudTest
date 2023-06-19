package org.inmobiliario.model.dto;

import java.io.Serializable;

public class CoordenadasDTO implements Serializable {

	private static final long serialVersionUID = -2577603182508815728L;
	private double latitud;
	private double longitud;

	public CoordenadasDTO() {
		super();
	}

	public CoordenadasDTO(double latitudParam, double longitudParam) {
		super();
		this.latitud = latitudParam;
		this.longitud = longitudParam;
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
		return "CoordenadasDTO [latitud=" + latitud + ", longitud=" + longitud + "]";
	}

}
