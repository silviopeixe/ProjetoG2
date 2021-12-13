package com.bcopstein;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CarregadorDeEmails implements ICarregadorDeEmails{
    public static final String filename = "emails.csv";
    private List<Email> lstEmails;

    public CarregadorDeEmails(){
        lstEmails = new LinkedList<>();
    }

    public Collection<Email> emails(){
        return lstEmails;
    }

    public void carregaDados() {
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir + "/" + filename;
        Path path = Paths.get(nameComplete);

        String linha = "";
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))) {
            //Pula a linha de cabecalho
            linha = sc.nextLine();
            // Extrai os dados das linhas seguintes
            while(sc.hasNext()){
                linha = sc.nextLine();
                String[] dados = linha.split((","));
                String emailOrigem = dados[1];
                String emailDestino = dados[2];
                String assunto = dados[3];
                Email email = new Email(emailOrigem, emailDestino, assunto);
                lstEmails.add(email);
            }
        } catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
    }
}
