package org.inmobiliario.service;

import org.springframework.stereotype.Service;

@Service
public class PetitionService {

	private String tracePrototype;
	
	public void getTracePrototype() {
		System.out.println("Prototype-Scope: " + tracePrototype + ", hashcode: " + this.hashCode());
	}
	
	public void setTracePrototype(String tracePrototypeParam) {
		this.tracePrototype = tracePrototypeParam;
	}
}
