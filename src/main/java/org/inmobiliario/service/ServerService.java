package org.inmobiliario.service;

public class ServerService {

	private String traceSingleton;

	public void getTraceSingleton() {
		System.out.println("Sinlgeton-Scope: " + traceSingleton + ", hashcode: " + this.hashCode());
	}

	public void setTraceSingleton(String traceSingletonParam) {
		this.traceSingleton = traceSingletonParam;
	}
}
