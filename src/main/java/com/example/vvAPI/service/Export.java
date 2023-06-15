package com.example.vvAPI.service;

import com.example.vvAPI.domain.CEP;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class Export {
    public static void exportarParaArquivo(CEP cep, String nomeArquivo) {

        String conteudo = cep.toTexto();

        try (OutputStreamWriter  writer = new OutputStreamWriter(new FileOutputStream(nomeArquivo), StandardCharsets.UTF_8)) {
            writer.write(conteudo);
            System.out.println("Arquivo exportado com sucesso: " + nomeArquivo);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao exportar arquivo: " + e.getMessage());
        }
    }
}
