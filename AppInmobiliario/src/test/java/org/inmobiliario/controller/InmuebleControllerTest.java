package org.inmobiliario.controller;

import java.util.ArrayList;
import java.util.List;

import org.inmobiliario.model.dto.InmuebleDTO;
import org.inmobiliario.service.InmuebleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class InmuebleControllerTest extends ArgumentMatchers {

	@InjectMocks private InmuebleController inmuebleController;
	@Mock private InmuebleService inmService;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void createInmuebleTest_HappyPath() {
		String request = "{ \"\"tipoInmueble\"\" : \"\"DEPARTAMENTO\"\", \"\"ubicacion\"\" : { \"\"pais\"\" : \"\"Mexico\"\", \"\"estado\"\" : \"\"Ciudad de Mexico\"\", \"\"ciudad\"\" : \"\"Ciudad de Mexico\"\", \"\"municipio\"\" : \"\"Coyoacan\"\", \"\"codigoPostal\"\" : 40060, \"\"colonia\"\" : \"\"Ocampo\"\", \"\"numeroExterior\"\" : \"\"23\"\", \"\"numeroInterior\"\" : \"\"320 A\"\", \"\"coordenadas\"\" : { \"\"latitud\"\" : 99.1, \"\"longitud\"\" : -91.02 } }, \"\"estatusInmueble\"\" : \"\"DISPONIBLE\"\", \"\"largo\"\" : 21.0, \"\"ancho\"\" : 7.0, \"\"precioXMetroCuadrado\"\" : \"\"4650.00\"\" }";
		InmuebleDTO inmueble= new InmuebleDTO();
		Mockito.when(inmService.addInmueble(any())).thenReturn(inmueble);
		ResponseEntity<InmuebleDTO> responseMock = inmuebleController.createInmueble(request);
		Assertions.assertNotNull(responseMock);
	}
	
	@Test
	void readInmueblesTest_HappyPath() {
		List<InmuebleDTO> inmuebles = new ArrayList<>();
		InmuebleDTO inmueble1 = new InmuebleDTO();
		inmuebles.add(inmueble1);
		Mockito.when(inmService.getInmuebles()).thenReturn(inmuebles);
		ResponseEntity<List<InmuebleDTO>> responseMock = inmuebleController.readInmuebles();
		Assertions.assertNotNull(responseMock);
	}
	 
	@Test
	void updateInmuebleTest_HappyPath() {
		InmuebleDTO inmueble = new InmuebleDTO();
		inmueble.setAncho(9.0);
		inmueble.setLargo(18.0);
		Mockito.when(inmService.updateInmueble(3, inmueble)).thenReturn(new InmuebleDTO());
		ResponseEntity<InmuebleDTO> responseMock = inmuebleController.updateInmueble(3, inmueble);
		Assertions.assertNotNull(responseMock);
	}
	
	@Test
	void deleteInmuebleTest_HappyPath() {
		InmuebleDTO inmueble = new InmuebleDTO();
		Mockito.when(inmService.getInmueble(3)).thenReturn(inmueble);
		Mockito.doNothing().when(inmService).deleteInmueble(3);
		ResponseEntity<InmuebleDTO> responseMock = inmuebleController.deleteInmuebles(3);
		Assertions.assertNotNull(responseMock);
	}
}
