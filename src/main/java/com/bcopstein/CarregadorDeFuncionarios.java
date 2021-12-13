package com.bcopstein;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CarregadorDeFuncionarios implements ICarregadorDeFuncionarios {
    public static final String filename = "funcionarios.csv";
    public Map<String,Funcionario> dicFuncionarios;

    public CarregadorDeFuncionarios(){
        dicFuncionarios = new HashMap<>();
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
                int id = Integer.parseInt(dados[0]);
                String email = dados[1];
                String nome = dados[2];
                String sobrenome = dados[3];
                String sexo = dados[4];
                Funcionario f = new Funcionario(id, nome, sobrenome, email, sexo);
                dicFuncionarios.put(email,f);
            }
        } catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
    }

    @Override
    public Set<String> chaves() {
        return dicFuncionarios.keySet();
    }

    @Override
    public Collection<Funcionario> funcionarios() {
        return dicFuncionarios.values();
    }

    @Override
    public Funcionario get(String email) {
        return dicFuncionarios.get(email);
    }
}
