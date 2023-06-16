package com.example.vvAPI;

import com.example.vvAPI.domain.CEP;
import com.example.vvAPI.exceptions.CEPDoesNotExistsException;
import com.example.vvAPI.exceptions.InvalidCEPFormatException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class ClienteTest {

	@Test
	public void consultarSeCEPExiste() {
		Cliente client = new Cliente();
		CEP cep = client.consultarCEP("62760000");
		assertNotNull(cep);
	}

	@Test
	public void consultarSeCEPNaoExiste() {
		Cliente client = new Cliente();
		assertThrows(CEPDoesNotExistsException.class, () ->{
			client.consultarCEP("99999999");
		});
	}

	@Test
	public void consultarSeCEPEValido() {
		Cliente client = new Cliente();
		assertThrows(InvalidCEPFormatException.class, () -> {
			client.consultarCEP("123");
		});
	}
}
