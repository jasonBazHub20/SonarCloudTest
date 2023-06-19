package org.inmobiliario.controller;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.inmobiliario.model.dto.InmuebleDTO;
import org.inmobiliario.service.InmuebleService;
import org.inmobiliario.service.PetitionService;
import org.inmobiliario.service.ServerService;
import org.inmobiliario.service.SessionService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/inmueble")
public class InmuebleController {
	
	@Autowired private InmuebleService inmuebleService;
	@Autowired private SessionService sessionService;
	@Autowired private ServerService singletonService;
	
	@RequestMapping(value = "/alta", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE , produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InmuebleDTO> createInmueble(@RequestBody String inmueble) {
		System.out.println("Inmueble method-execution: /alta:" + inmueble);
		InmuebleDTO inmuebleAgregado = null;
		try {
		
			InmuebleDTO inmuebleNuevo = new ObjectMapper().readValue(inmueble, InmuebleDTO.class);
			System.out.println("Se parseo correctamente:"+inmuebleNuevo);
			inmuebleAgregado = inmuebleService.addInmueble(inmuebleNuevo);
		} 
		catch (Exception ex) {
			System.out.println("Excepcion en createInmueble:" + ex.getMessage());
		}
		return ResponseEntity.ok(inmuebleAgregado);
	}

	@RequestMapping(value = "/consulta", method = RequestMethod.GET)
	public ResponseEntity<List<InmuebleDTO>> readInmuebles() {
		System.out.println("Inmueble method-execution: /consulta");
		List<InmuebleDTO> inmuebles = null;
		try {
			getSingleton();
			getSession("Inicial");
			getPrototype("Genera Nuevo Tag");
			inmuebles = inmuebleService.getInmuebles();
			getPrototype("Genera Nuevo Tag");
			getSession("Final");
		}
		catch(Exception ex) {
			System.out.println("Excepcion en readInmuebles:" + ex.getMessage());
		}
		return ResponseEntity.ok(inmuebles);
	}

	@RequestMapping(value = "/modifica/{id}", method = RequestMethod.PUT, consumes = { MediaType.TEXT_PLAIN_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<InmuebleDTO> updateInmueble(@PathVariable("id") int id, @RequestBody InmuebleDTO inmueble) {
		System.out.println("Inmueble method-execution: /modifica");
		InmuebleDTO inmuebleModificado = null;
		try {
			inmuebleModificado = inmuebleService.updateInmueble(id, inmueble);
		}
		catch(Exception ex) {
			System.out.println("Excepcion en updateInmueble:" + ex.getMessage());
		}
		
		return ResponseEntity.ok(inmuebleModificado);
	}

	@RequestMapping(value = "/elimina/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<InmuebleDTO> deleteInmuebles(@PathVariable("id") int id) {
		System.out.println("Inmueble method-execution: /elimina/{porId}");
		InmuebleDTO inmuebleExistente = null;
		try {
			inmuebleExistente = inmuebleService.getInmueble(id);
			if(inmuebleExistente == null) {
				System.out.println("No existe inmueble");
				throw new EmptyResultDataAccessException(1);
			}	
			inmuebleService.deleteInmueble(id);
			System.out.println("Inmueble eliminado");

		}
		catch(EmptyResultDataAccessException  | EntityNotFoundException exEmpty) {
			System.out.println("No se encontro el recurso con id:" + id);
			return new ResponseEntity<>(new InmuebleDTO(), HttpStatus.NOT_FOUND);
		}
		catch(Exception ex) {
			System.out.println("No se pudo eliminar el inmueble con id:" + id);
			return new ResponseEntity<>(new InmuebleDTO(), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(inmuebleExistente);
	}
	
	private void getPrototype(String statusPrototype) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("BeanFactory.xml");      
        PetitionService prototypeService = (PetitionService)applicationContext.getBean("petitionId");
		prototypeService.setTracePrototype(statusPrototype);
		prototypeService.getTracePrototype();
		
		((AbstractApplicationContext) applicationContext).close();
	}
	
	private void getSession(String statusSession) {
        sessionService.getTraceSession(statusSession);;
	}
	
	private void getSingleton() {
		singletonService.setTraceSingleton("Inicio Singleton");
		singletonService.getTraceSingleton();
		
	}
}
