package org.inmobiliario.model.dto;

import java.io.Serializable;

import org.inmobiliario.model.EstatusInmuebleEnum;
import org.inmobiliario.model.TipoInmuebleEnum;

public class InmuebleDTO implements Serializable {

	private static final long serialVersionUID = 4916651622052417530L;
	
	private TipoInmuebleEnum tipoInmueble;
	private UbicacionDTO ubicacion;
	private EstatusInmuebleEnum estatusInmueble;
	private double largo;
	private double ancho;
	private String precioXMetroCuadrado;

	public InmuebleDTO() {
		super();
	}

	public TipoInmuebleEnum getTipoInmueble() {
		return tipoInmueble;
	}

	public void setTipoInmueble(TipoInmuebleEnum tipoInmueble) {
		this.tipoInmueble = tipoInmueble;
	}

	public UbicacionDTO getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(UbicacionDTO ubicacion) {
		this.ubicacion = ubicacion;
	}

	public EstatusInmuebleEnum getEstatusInmueble() {
		return estatusInmueble;
	}

	public void setEstatusInmueble(EstatusInmuebleEnum estatusInmueble) {
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
	
	private double getPrecioInmuebleXMtCuadrado() {
		double PRECIO_DEFAULT = 1000;
		double totalMtCuadrados = ancho * largo;
		double precioTotal;
		if(precioXMetroCuadrado != null) {
			precioTotal = Double.parseDouble(precioXMetroCuadrado);
		}
		else {
			precioTotal = PRECIO_DEFAULT;
		}
		precioTotal *= totalMtCuadrados;
		System.out.println("Invocacion de metodo private por medio de reflexion:"+precioTotal);
		return precioTotal;
	}

	@Override
	public String toString() {
		return "InmuebleDTO [tipoInmueble=" + tipoInmueble + ", ubicacion=" + ubicacion + ", estatusInmueble="
				+ estatusInmueble + ", largo=" + largo + ", ancho=" + ancho + ", precioXMetroCuadrado="
				+ precioXMetroCuadrado + "]";
	}

}
