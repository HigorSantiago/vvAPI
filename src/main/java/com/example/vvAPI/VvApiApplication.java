package com.example.vvAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VvApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VvApiApplication.class, args);
		Cliente cliente = new Cliente();
		cliente.consultarCEP("62760000");
	}

}
