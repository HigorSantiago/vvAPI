package com.example.vvAPI.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.example.vvAPI.domain.CEP;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CepAPI {
    public CEP obterDadosAPI(String cep) throws MalformedURLException, IOException {

        if (cep == null) {
            System.out.println("O cep informado é invalido");
            return null;
        }

        String urlAPI = "https://viacep.com.br/ws/" + cep + "/json/";
        JsonNode cepJson = new ObjectMapper().readTree(new URL(urlAPI));


        CEP cepReturn = new CEP(
            cepJson.get("logradouro").toString(),
            cepJson.get("bairro").toString(),
            cepJson.get("localidade").toString(),
            cepJson.get("uf").toString(),
            cepJson.get("ibge").toString(),
            cepJson.get("gia").toString(),
            cepJson.get("ddd").toString(),
            cepJson.get("siafi").toString(),
            cepJson.get("cep").toString()
        );

        return cepReturn;

        // String urlAPI = "https://viacep.com.br/ws/"+cep+"/json/"; // URL da API
        // externa
        // RestTemplate restTemplate = new RestTemplate();

        // try{
        // ResponseEntity<CEP> response = restTemplate.exchange(urlAPI, HttpMethod.GET,
        // null, CEP.class);
        // if (response.getStatusCode().is2xxSuccessful()) {
        // return response.getBody();
        // } else {
        // System.err.println("Erro na requisição: " + response.getStatusCodeValue());
        // return null;
        // }
        // } catch (HttpClientErrorException e){
        // System.err.println("Erro na requisição: " + e.getStatusCode());
        // return null;
        // }

    }

}
