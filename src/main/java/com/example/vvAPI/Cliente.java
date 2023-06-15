package com.example.vvAPI;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.example.vvAPI.domain.CEP;
import com.example.vvAPI.service.CepAPI;

import com.example.vvAPI.service.Export;

public class Cliente {
    private final CepAPI api = new CepAPI();

    public CEP consultarCEP(String cepInfo) throws UnsupportedEncodingException, IOException{
        CEP cep = api.obterDadosAPI(cepInfo);
        System.out.println(cep);
        Export.exportarParaArquivo(cep,"dados.txt");
        return cep;
    }


}
