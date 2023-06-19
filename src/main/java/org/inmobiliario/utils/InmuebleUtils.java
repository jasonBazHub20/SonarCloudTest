package org.inmobiliario.utils;

import org.inmobiliario.model.EstatusInmuebleEnum;
import org.inmobiliario.model.TipoInmuebleEnum;
import org.inmobiliario.model.dto.CoordenadasDTO;
import org.inmobiliario.model.dto.InmuebleDTO;
import org.inmobiliario.model.dto.UbicacionDTO;
import org.inmobiliario.model.entity.Coordenadas;
import org.inmobiliario.model.entity.Inmueble;
import org.inmobiliario.model.entity.Ubicacion;

public class InmuebleUtils {
	
	public static Inmueble convertDTOToEntity(InmuebleDTO inmuebleDTO) {
		Inmueble inmuebleRequest = new Inmueble();
		inmuebleRequest.setTipoInmueble(inmuebleDTO.getTipoInmueble().getDescripcion());
		Ubicacion ubicacion = new Ubicacion();
		ubicacion.setPais(inmuebleDTO.getUbicacion().getPais());
		ubicacion.setEstado(inmuebleDTO.getUbicacion().getEstado());
		ubicacion.setCiudad(inmuebleDTO.getUbicacion().getCiudad());
		ubicacion.setMunicipio(inmuebleDTO.getUbicacion().getMunicipio());
		ubicacion.setCodigoPostal(inmuebleDTO.getUbicacion().getCodigoPostal());
		ubicacion.setColonia(inmuebleDTO.getUbicacion().getColonia());
		ubicacion.setNumeroExterior(inmuebleDTO.getUbicacion().getNumeroExterior());
		ubicacion.setNumeroInterior(inmuebleDTO.getUbicacion().getNumeroInterior());
		Coordenadas coordenadas = new Coordenadas();
		coordenadas.setLatitud(inmuebleDTO.getUbicacion().getCoordenadas().getLatitud());
		coordenadas.setLongitud(inmuebleDTO.getUbicacion().getCoordenadas().getLongitud());
		ubicacion.setCoordenadas(coordenadas);
		
		inmuebleRequest.setUbicacion(ubicacion);
		inmuebleRequest.setEstatusInmueble(inmuebleDTO.getEstatusInmueble().getDescripcion());
		inmuebleRequest.setLargo(inmuebleDTO.getLargo());
		inmuebleRequest.setAncho(inmuebleDTO.getAncho());
		inmuebleRequest.setPrecioXMetroCuadrado(inmuebleDTO.getPrecioXMetroCuadrado());
		return inmuebleRequest;
	} 
	
	public static InmuebleDTO convertEntityToDTO(Inmueble inmueble) {
		InmuebleDTO inmuebleRequest = new InmuebleDTO();
		inmuebleRequest.setTipoInmueble(getTipoInmuebleEnum(inmueble.getTipoInmueble()));
		UbicacionDTO ubicacion = new UbicacionDTO();
		ubicacion.setPais(inmueble.getUbicacion().getPais());
		ubicacion.setEstado(inmueble.getUbicacion().getEstado());
		ubicacion.setCiudad(inmueble.getUbicacion().getCiudad());
		ubicacion.setMunicipio(inmueble.getUbicacion().getMunicipio());
		ubicacion.setCodigoPostal(inmueble.getUbicacion().getCodigoPostal());
		ubicacion.setColonia(inmueble.getUbicacion().getColonia());
		ubicacion.setNumeroExterior(inmueble.getUbicacion().getNumeroExterior());
		ubicacion.setNumeroInterior(inmueble.getUbicacion().getNumeroInterior());
		CoordenadasDTO coordenadas = new CoordenadasDTO();
		coordenadas.setLatitud(inmueble.getUbicacion().getCoordenadas().getLatitud());
		coordenadas.setLongitud(inmueble.getUbicacion().getCoordenadas().getLongitud());
		ubicacion.setCoordenadas(coordenadas);
		
		inmuebleRequest.setUbicacion(ubicacion);
		inmuebleRequest.setEstatusInmueble(getEstatusInmuebleEnum(inmueble.getEstatusInmueble()));
		inmuebleRequest.setLargo(inmueble.getLargo());
		inmuebleRequest.setAncho(inmueble.getAncho());
		inmuebleRequest.setPrecioXMetroCuadrado(inmueble.getPrecioXMetroCuadrado());
		return inmuebleRequest;
	} 
	private static EstatusInmuebleEnum getEstatusInmuebleEnum(String estatusInmueble) {
		EstatusInmuebleEnum estatus = null;
		switch(estatusInmueble) {
		case "DISPONIBLE":
			estatus = EstatusInmuebleEnum.DISPONIBLE;
			break;
		case "VENDIDO":
			estatus = EstatusInmuebleEnum.VENDIDO;
			break;
		default:
			estatus = EstatusInmuebleEnum.DESCONOCIDO;
		}
		return estatus;
	}
	
	private static TipoInmuebleEnum getTipoInmuebleEnum(String tipoInmueble) {
		TipoInmuebleEnum tipo = null;
		switch(tipoInmueble) {
		case "TERRENO":
			tipo = TipoInmuebleEnum.TERRENO;
			break;
		case "DEPARTAMENTO":
			tipo = TipoInmuebleEnum.DEPARTAMENTO;
			break;
		case "CASA":
			tipo = TipoInmuebleEnum.CASA;
			break;
		default:
			tipo = TipoInmuebleEnum.INMUEBLE;
		}
		return tipo;
		
	}
	
}
