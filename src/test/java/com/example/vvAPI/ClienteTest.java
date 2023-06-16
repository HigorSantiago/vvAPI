package com.example.vvAPI;

import com.example.vvAPI.domain.CEP;
import com.example.vvAPI.exceptions.CEPDoesNotExistsException;
import com.example.vvAPI.exceptions.InvalidCEPFormatException;
import com.example.vvAPI.service.CepAPI;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;

public class ClienteTest {
	@Test
	public void consultarSeCEPExiste() {
		CepAPI cepApi = Mockito.mock(CepAPI.class);
	    Cliente client = new Cliente(cepApi);
		String numeroCep = "62760000";
        CEP cepReturn = new CEP("", "", "Baturité", "CE", "2302107", 
"", "85", "1341", "62760-000");

        Mockito.when(cepApi.obterDadosAPI(numeroCep)).thenReturn(cepReturn);

	    CEP cep = client.consultarCEP("62760000");

	    assertNotNull(cep);
	}

	@Test
	public void consultarSeCEPNaoExiste() {
		String CEPInvalido = "99999999";
		CepAPI cepApi = Mockito.mock(CepAPI.class);
		Cliente client = new Cliente(cepApi);

		Mockito.when(cepApi.obterDadosAPI(CEPInvalido)).thenThrow(new CEPDoesNotExistsException());

		assertThrows(CEPDoesNotExistsException.class, () -> {
			client.consultarCEP("99999999");
		});
	}

	@Test
	public void consultarSeCEPEValido() {
		CepAPI cepApi = Mockito.mock(CepAPI.class);
		Cliente client = new Cliente(cepApi);
		String CEPInvalido = "123";

		Mockito.when(cepApi.obterDadosAPI(CEPInvalido)).thenThrow(new InvalidCEPFormatException());

		assertThrows(InvalidCEPFormatException.class, () -> {
			client.consultarCEP("123");
		});
	}
}
