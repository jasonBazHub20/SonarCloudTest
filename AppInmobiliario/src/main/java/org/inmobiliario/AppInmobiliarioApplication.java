package org.inmobiliario;

import org.inmobiliario.service.ServerService;
import org.inmobiliario.service.SessionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.SessionScope;

@SpringBootApplication
public class AppInmobiliarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppInmobiliarioApplication.class, args);
	}
	
	@Bean//Por definicion @Bean es un singleton
	public ServerService serverService() {
		return new ServerService();
	}
	
	@Bean
	@SessionScope
	public SessionService sessionService() {
	    return new SessionService();
	}
	
}
