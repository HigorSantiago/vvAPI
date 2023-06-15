package com.example.vvAPI;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class VvApiApplication {

	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		Cliente cliente = new Cliente();
		cliente.consultarCEP("60867540");
	}

}
