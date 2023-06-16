package com.example.vvAPI;

import com.example.vvAPI.domain.CEP;
import com.example.vvAPI.exceptions.CEPDoesNotExistsException;
import com.example.vvAPI.exceptions.InvalidCEPFormatException;
import com.example.vvAPI.service.CepAPI;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.mockito.Mockito;

public class ClienteTest {
    private CepAPI cepApi = Mockito.mock(CepAPI.class);
	
	@Test
	public void consultarSeCEPExiste() {
		Cliente client = new Cliente(cepApi);
		CEP cep = client.consultarCEP("62760000");
		assertNotNull(cep);
	}

	@Test
	public void consultarSeCEPNaoExiste() {
		Cliente client = new Cliente(cepApi);
		assertThrows(CEPDoesNotExistsException.class, () ->{
			client.consultarCEP("99999999");
		});
	}

	@Test
	public void consultarSeCEPEValido() {
		Cliente client = new Cliente(cepApi);
		assertThrows(InvalidCEPFormatException.class, () -> {
			client.consultarCEP("123");
		});
	}
}
