package org.inmobiliario.model;

public enum TipoInmuebleEnum {

	TERRENO("TERRENO"), DEPARTAMENTO("DEPARTAMENTO"), CASA("CASA"), INMUEBLE("INMUEBLE");
	private String descripcion;
	
	private TipoInmuebleEnum(String descripcionParam) {
		this.descripcion = descripcionParam;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
}
