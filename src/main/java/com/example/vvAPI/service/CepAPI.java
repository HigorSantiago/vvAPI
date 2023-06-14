package com.example.vvAPI.service;
import org.springframework.http.HttpMethod;
import com.example.vvAPI.domain.CEP;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class CepAPI {
    public CEP obterDadosAPI(String cep) {

        if(cep == null){
            System.out.println("O cep informado é invalido");
            return null;
        }

        String urlAPI = "https://viacep.com.br/ws/"+cep+"/json/"; // URL da API externa
        RestTemplate restTemplate = new RestTemplate();

        try{
            ResponseEntity<CEP> response = restTemplate.exchange(urlAPI, HttpMethod.GET, null, CEP.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            } else {
                System.err.println("Erro na requisição: " + response.getStatusCodeValue());
                return null;
            }
        } catch (HttpClientErrorException e){
                System.err.println("Erro na requisição: " + e.getStatusCode());
                return null;
        }

    }

}
