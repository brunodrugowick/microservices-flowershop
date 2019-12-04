package dev.drugowick.microservice.carrier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class CarrierApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarrierApplication.class, args);
	}

}
