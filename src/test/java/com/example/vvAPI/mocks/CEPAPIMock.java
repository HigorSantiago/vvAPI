package com.example.vvAPI.mocks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.example.vvAPI.Cliente;
import com.example.vvAPI.domain.CEP;
import com.example.vvAPI.exceptions.CEPDoesNotExistsException;
import com.example.vvAPI.exceptions.InvalidCEPFormatException;

public class CEPAPIMock {
    private Cliente cliente;

    @Before
    public void setup(){
        this.cliente = mock(Cliente.class);
    }

    @Test
	public void consultarCEPCerto() {
        CEP cep = new CEP("", "", "Baturité", "CE", "2302107", 
                          "", "85", "1341", "62760-000");
        when(cliente.consultarCEP("62760000")).thenReturn(cep);
        assertEquals(cep, cliente.consultarCEP("62760000"));
	}

	@Test
	public void consultarSeCEPNaoExiste() {
		when(cliente.consultarCEP("99999999")).thenThrow(CEPDoesNotExistsException.class);
		assertThrows(CEPDoesNotExistsException.class, () ->{
			cliente.consultarCEP("99999999");
		});
	}
	
	@Test
	public void consultarSeCEPEValido() {
		when(cliente.consultarCEP("123")).thenThrow(InvalidCEPFormatException.class);
		assertThrows(InvalidCEPFormatException.class, () -> {
			cliente.consultarCEP("123");
		});
	}

}
