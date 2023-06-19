package org.inmobiliario.service;

import java.util.ArrayList;
import java.util.List;

import org.inmobiliario.model.dto.CoordenadasDTO;
import org.inmobiliario.model.dto.InmuebleDTO;
import org.inmobiliario.model.dto.UbicacionDTO;
import org.inmobiliario.model.entity.Coordenadas;
import org.inmobiliario.model.entity.Inmueble;
import org.inmobiliario.model.entity.Ubicacion;
import org.inmobiliario.repository.InmuebleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class InmuebleServiceTest extends ArgumentMatchers {

	@InjectMocks private InmuebleService inmuebleService;
	@Mock private InmuebleRepository inmRepo;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	//@Test
	void addInmuebleTest() {
		InmuebleDTO inmuebleRequestDTO = new InmuebleDTO();
		UbicacionDTO ubicacionDTO = new UbicacionDTO();
		CoordenadasDTO coorDTO = new CoordenadasDTO();
		ubicacionDTO.setCoordenadas(coorDTO);
		inmuebleRequestDTO.setUbicacion(ubicacionDTO);
		
		List<Inmueble> listaInmuebles = new ArrayList<>();
		Ubicacion ubicacion = new Ubicacion();
		Coordenadas coor = new Coordenadas();
		ubicacion.setCoordenadas(coor);
		Inmueble inm1 = new Inmueble();
		inm1.setId(1);
		inm1.setUbicacion(ubicacion);
		Inmueble inm2 = new Inmueble();
		inm2.setId(2);
		inm2.setUbicacion(ubicacion);
		listaInmuebles.add(inm1);
		listaInmuebles.add(inm2);
		
		Mockito.when(inmRepo.findAll()).thenReturn(listaInmuebles);
		
		Inmueble inmResponse = new Inmueble();
		inmResponse.setId(3);
		inmResponse.setUbicacion(ubicacion);
		Mockito.when(inmRepo.save(any())).thenReturn(inmResponse);
		InmuebleDTO inmuebleResponseDTO = inmuebleService.addInmueble(inmuebleRequestDTO);
		Assertions.assertNotNull(inmuebleResponseDTO);
		
	}
	
	//@Test
	void getInmuebleTest() {
		Mockito.when(inmRepo.getReferenceById(2l)).thenReturn(new Inmueble());
		InmuebleDTO inmuebleResponse = inmuebleService.getInmueble(2);
		Assertions.assertNotNull(inmuebleResponse);
	}
	
	//@Test
	void getInmueblesTest() {
	
		List<Inmueble> listaInmuebles = new ArrayList<>();
		Ubicacion ubicacion = new Ubicacion();
		Coordenadas coor = new Coordenadas();
		ubicacion.setCoordenadas(coor);
		Inmueble inm1 = new Inmueble();
		inm1.setId(1);
		inm1.setUbicacion(ubicacion);
		Inmueble inm2 = new Inmueble();
		inm2.setId(2);
		inm2.setUbicacion(ubicacion);
		listaInmuebles.add(inm1);
		listaInmuebles.add(inm2);
		Mockito.when(inmRepo.findAll()).thenReturn(listaInmuebles);
		List<InmuebleDTO> inmueblesDTO = inmuebleService.getInmuebles();
		Assertions.assertNotNull(inmueblesDTO);
	}
	
	//@Test
	void updateInmuebleTest() {
		InmuebleDTO inmuebleDTORequest = new InmuebleDTO();
		Mockito.when(inmRepo.save(any())).thenReturn(new Inmueble());
		InmuebleDTO inmuebleDTOResponse = inmuebleService.updateInmueble(2, inmuebleDTORequest);
		Assertions.assertNotNull(inmuebleDTOResponse);
	}
	
	//@Test
	void deleteInmuebleTest() {
		long num = 3;
		Mockito.doNothing().when(inmRepo).deleteById(num);
		Assertions.assertDoesNotThrow(() ->inmuebleService.deleteInmueble(num));
	}
}
