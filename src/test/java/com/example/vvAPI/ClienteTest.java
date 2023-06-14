package com.example.vvAPI;

import com.example.vvAPI.domain.CEP;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClienteTest {

	@Test
	public void consultarCEPCerto() {
		Cliente client = new Cliente();
		client.consultarCEP("62760000");
	}


	@Test
	public void consultarCEPErrado() {
		Cliente client = new Cliente();
		CEP cep = client.consultarCEP("123");
		assert(cep == null);
	}


	@Test
	public void consultarCEPNulo() {
		Cliente client = new Cliente();
		CEP cep = client.consultarCEP(null);
		assert(cep == null);
	}

}
