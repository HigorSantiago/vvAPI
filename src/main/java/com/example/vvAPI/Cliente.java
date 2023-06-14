package com.example.vvAPI;

import com.example.vvAPI.domain.CEP;
import com.example.vvAPI.service.CepAPI;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Cliente {
    private CepAPI api = new CepAPI();

    public CEP consultarCEP(String cepInfo){
        CEP cep = api.obterDadosAPI(cepInfo);
        System.out.println(cep);
        exportarParaArquivo(cep,"dados.txt");
        return cep;
    }

    public static void exportarParaArquivo(CEP cep, String nomeArquivo) {

        String conteudo = cep.toTexto();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.write(conteudo);
            System.out.println("Arquivo exportado com sucesso: " + nomeArquivo);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao exportar arquivo: " + e.getMessage());
        }
    }
}
