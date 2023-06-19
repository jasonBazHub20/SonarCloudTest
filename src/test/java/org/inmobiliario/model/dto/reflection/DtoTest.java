package org.inmobiliario.model.dto.reflection;

import java.lang.reflect.Field;

import org.inmobiliario.model.dto.InmuebleDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DtoTest {

	@Test
	void getPrecioInmuebleXMtCuadradoTest_Reflection() {
		System.out.println("Inicia Test");
		InmuebleDTO inmuebleDTO = new InmuebleDTO();
		inmuebleDTO.setLargo(10);
		inmuebleDTO.setAncho(8);
		inmuebleDTO.setPrecioXMetroCuadrado("2000");
		Field[] infoInmueble = inmuebleDTO.getClass().getDeclaredFields();
		for(Field x : infoInmueble) {
			x.setAccessible(true);
			System.out.println("Get Name Reflect:" + x.getName());
			System.out.println("Get Type Reflect:"+x.getType());
			try {
				System.out.println("Get Reflect:" + x.get(inmuebleDTO));
			} catch (Exception e) {
				System.out.println("No se pudo obtener get()");
			}
		}	
	}

}
