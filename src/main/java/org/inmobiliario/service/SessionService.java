package org.inmobiliario.service;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SessionService {

	private String traceSession;

	public SessionService() {
        ServletRequestAttributes servletRequestAttributes =
                (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        setTraceSession(servletRequestAttributes.getSessionId());
	}
	
	private void setTraceSession(String traceSessionParam) {
		this.traceSession = traceSessionParam;
	}
	
	public void getTraceSession(String status) {
		System.out.println("Session-Scope: " + status + ", Token: " + traceSession + ", hashcode: " + this.hashCode());
	}
	
	
}
