package com.example.vvAPI.service;

import com.example.vvAPI.domain.CEP;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Export {
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
