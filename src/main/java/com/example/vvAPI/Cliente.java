package com.example.vvAPI;


import com.example.vvAPI.domain.CEP;
import com.example.vvAPI.exceptions.InvalidCEPFormatException;
import com.example.vvAPI.service.CepAPI;

import com.example.vvAPI.service.Export;

public class Cliente {
    private final CepAPI api = new CepAPI();

    public CEP consultarCEP(String cepInfo) {
        CEP cep = api.obterDadosAPI(cepInfo);
        // System.out.println(cep);
        Export.exportarParaArquivo(cep, "dados.txt");
        return cep;
    }

}
