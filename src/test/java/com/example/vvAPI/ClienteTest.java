package com.example.vvAPI;

import com.example.vvAPI.domain.CEP;
import com.example.vvAPI.exceptions.CEPDoesNotExistsException;
import com.example.vvAPI.exceptions.InvalidCEPFormatException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class ClienteTest {

	@Test
	public void consultarCEPCerto() {
		Cliente client = new Cliente();
		CEP cep = client.consultarCEP("62760000");
		assertNotNull(cep);
	}

	@Test
	public void consultarSeCEPExist() {
		Cliente client = new Cliente();
		assertThrows(CEPDoesNotExistsException.class, () ->{
			client.consultarCEP("99999999");
		});
	}

	@Test
	public void consultarCEPComMenosCaracteres() {
		Cliente client = new Cliente();
		assertThrows(InvalidCEPFormatException.class, () -> {
			client.consultarCEP("123");
		});
	}

	@Test
	public void consultarCEPComMaisCaracteres() {
		Cliente client = new Cliente();
		assertThrows(InvalidCEPFormatException.class, () -> {
			client.consultarCEP("950100100");
		});
	}

	@Test
	public void consultarCEPComEspaco() {
		Cliente client = new Cliente();
		assertThrows(InvalidCEPFormatException.class, () -> {
			client.consultarCEP("95010 10");
		});
	}

	@Test
	public void consultarCEPComLetras() {
		Cliente client = new Cliente();
		assertThrows(InvalidCEPFormatException.class, () -> {
			client.consultarCEP("95010A10");
		});
	}

	@Test
	public void consultarCEPNulo() {
		Cliente client = new Cliente();
		assertThrows(InvalidCEPFormatException.class, () -> {
			client.consultarCEP(null);
		});
	}

}
