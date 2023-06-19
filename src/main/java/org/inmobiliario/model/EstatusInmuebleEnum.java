package org.inmobiliario.model;

public enum EstatusInmuebleEnum {

	VENDIDO("VENDIDO"), DISPONIBLE("DISPONIBLE"), DESCONOCIDO("DESCONOCIDO");
	
	private String descripcion;
	
	private EstatusInmuebleEnum(String descripcionParam) {
		this.descripcion = descripcionParam;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
