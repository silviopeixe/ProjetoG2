package com.bcopstein;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CarregadorDeEmailsTest {
    public static final String filename = "emails.csv";
    private String ErroEsperado;

    @Test
    void carregaDadosTest(){
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir + "/" + filename;
        Path path = Paths.get(nameComplete);
        //String linha = "";
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))) {
        }
        catch (IOException x) {
            ErroEsperado ="Erro de E/S: %s%n";
        }
        
        assertNotEquals("Erro de E/S: %s%n", ErroEsperado);
    }
}
