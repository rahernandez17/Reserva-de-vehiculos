package com.reservavehiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.reservavehiculos.*" })
public class ReservaDeVehiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservaDeVehiculosApplication.class, args);
	}

}
