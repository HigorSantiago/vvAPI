package com.example.vvAPI;

import com.example.vvAPI.service.CepAPI;

public class VvApiApplication {

	public static void main(String[] args) {
		CepAPI api = new CepAPI();
		Cliente cliente = new Cliente(api);
		
		cliente.consultarCEP("62760000");
	}

}
