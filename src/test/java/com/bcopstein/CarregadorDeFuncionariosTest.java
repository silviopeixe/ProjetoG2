package com.bcopstein;
import org.junit.jupiter.api.Test;
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

import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class CarregadorDeFuncionariosTest {
    private static final String filename = "funcionarios.csv";
    private Map<String,Funcionario> dicFuncionarios;
    private String ErroEsperado;

    @Test
    void CarregadorDeFuncionarioTest(){
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir + "/" + filename;
        Path path = Paths.get(nameComplete);

        String linha = "";
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))) {
        } catch (IOException x) {
            ErroEsperado ="Erro de E/S: %s%n";
        }
        assertNotEquals("Erro de E/S: %s%n", ErroEsperado);
    }
}
