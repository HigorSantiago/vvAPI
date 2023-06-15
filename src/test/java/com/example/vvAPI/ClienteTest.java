package com.example.vvAPI;

import com.example.vvAPI.domain.CEP;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClienteTest {

	@Test
	public void consultarCEPCerto() throws UnsupportedEncodingException, IOException {
		Cliente client = new Cliente();
		client.consultarCEP("62760000");
	}


	@Test
	public void consultarCEPErrado() throws UnsupportedEncodingException, IOException {
		Cliente client = new Cliente();
		CEP cep = client.consultarCEP("123");
		assert(cep == null);
	}


	@Test
	public void consultarCEPNulo() throws UnsupportedEncodingException, IOException {
		Cliente client = new Cliente();
		CEP cep = client.consultarCEP(null);
		assert(cep == null);
	}

}
