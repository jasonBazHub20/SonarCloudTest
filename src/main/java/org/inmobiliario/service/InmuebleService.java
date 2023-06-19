package org.inmobiliario.service;

import java.util.ArrayList;
import java.util.List;
import org.inmobiliario.model.dto.InmuebleDTO;
import org.inmobiliario.model.entity.Inmueble;
import org.inmobiliario.repository.InmuebleRepository;
import org.inmobiliario.utils.InmuebleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InmuebleService {

	@Autowired
	private InmuebleRepository inmuebleRepository;
	
	
	public InmuebleDTO addInmueble(InmuebleDTO inmuebleDTORequest) {
		List<Inmueble> inmueblesResponse = inmuebleRepository.findAll();
		int idInmueble = inmueblesResponse.stream().map(x -> (int)x.getId()).max(Integer::compare).get();
		Inmueble inmuebleRequest = InmuebleUtils.convertDTOToEntity(inmuebleDTORequest);
		inmuebleRequest.setId(++idInmueble);
		inmuebleRequest.getUbicacion().setId(idInmueble);
		inmuebleRequest.getUbicacion().getCoordenadas().setId(idInmueble);
		Inmueble inmuebleResponse = inmuebleRepository.save(inmuebleRequest);
		return InmuebleUtils.convertEntityToDTO(inmuebleResponse);
	}
	
	public InmuebleDTO getInmueble(long id) {
		Inmueble inmuebleResponse = inmuebleRepository.getReferenceById(id);
		return InmuebleUtils.convertEntityToDTO(inmuebleResponse);
	}
	
	public List<InmuebleDTO> getInmuebles() {
		List<Inmueble> inmueblesResponse = inmuebleRepository.findAll();
		List<InmuebleDTO> inmueblesResponseDTO = new ArrayList<>();
		for(Inmueble inm : inmueblesResponse) {
			System.out.println("Inmueble consultado con Id:" + inm);
			inmueblesResponseDTO.add(InmuebleUtils.convertEntityToDTO(inm));
		}
		return inmueblesResponseDTO;
	}
	
	public InmuebleDTO updateInmueble(int id, InmuebleDTO inmuebleDTORequest) {
		Inmueble inmuebleRequest = InmuebleUtils.convertDTOToEntity(inmuebleDTORequest);
		inmuebleRequest.setId(id);
		Inmueble inmuebleResponse =  inmuebleRepository.save(inmuebleRequest);
		System.out.println("Inmueble modificado con Id:" + inmuebleResponse);
		return InmuebleUtils.convertEntityToDTO(inmuebleResponse);
	}
	
	public void deleteInmueble(long id) {
		inmuebleRepository.deleteById(id);
	}
	
}
