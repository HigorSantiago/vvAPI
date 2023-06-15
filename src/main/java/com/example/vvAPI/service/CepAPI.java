package com.example.vvAPI.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.example.vvAPI.domain.CEP;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
public class CepAPI {
    public CEP obterDadosAPI(String cep) {

        if (cep == null) {
            // System.out.println("O cep informado é invalido");
            return null;
        }

        try{
            URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            if(connection.getResponseCode() == HttpURLConnection.HTTP_BAD_REQUEST){
                return null;
            }
            JsonNode cepJson = new ObjectMapper().readTree(url);
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
        }catch(MalformedURLException e){
            return null;
        }catch(IOException e){
            return null;
        }
        



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
