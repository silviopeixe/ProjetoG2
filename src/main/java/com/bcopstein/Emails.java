package com.bcopstein;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Emails {
    private ICarregadorDeEmails carregadorDeEmails;

    public Emails(ICarregadorDeEmails carregadorDeEmails) {
        this.carregadorDeEmails = carregadorDeEmails;
        carregadorDeEmails.carregaDados();
    }

    // Resposta da letra a: lista de assuntos
    public List<String> assuntos(){
        return carregadorDeEmails
            .emails()
            .stream()
            .map(e->e.getSubject())
            .sorted()
            .distinct()
            .collect(Collectors.toList());
    }

    // Resposta da letra b: assunto mais frequente/quantas vezes ocorreu
    String[] assuntoMaisFrequente(){
        // Cria um dicionário dos emails por assunto
        Map<String,List<Email>> emailsPorAssunto = carregadorDeEmails
            .emails()
            .stream()
            .collect(Collectors.groupingBy(e->e.getSubject()));
        // Determina o assunto mais frequente
        String assuntoMaisFrequente = emailsPorAssunto.keySet()
            .stream()
            .max(Comparator.comparing(key->emailsPorAssunto.get(key).size()))
            .get();
        // Determina a quantidade de ocorrências do assunto mais frequente
        Integer qtdade = emailsPorAssunto.get(assuntoMaisFrequente).size();
        // Monta a resposta
        String[] resposta = new String[2];
        resposta[0] = assuntoMaisFrequente;
        resposta[1] = qtdade.toString();

        return resposta;
    }

    // Resposta da letra c; que funcionário mais enviou um email de determinado assunto
    String remetenteQueMaisEnviouEmailAssunto(String assunto){
        // Cria um dicionário dos emails por assunto
        Map<String,List<Email>> emailsPorAssunto = carregadorDeEmails
            .emails()
            .stream()
            .collect(Collectors.groupingBy(e->e.getSubject()));
        // Cria um dicionário dos emails do "assunto" por funcionario
        Map<String,List<Email>> emailsPorRemetente = emailsPorAssunto
            .get(assunto)
            .stream()
            .collect(Collectors.groupingBy(e->e.getEmailOrigem()));
        // Retorna o remetente com mais emails
        return emailsPorRemetente.keySet()
            .stream()
            .max(Comparator.comparing(key->emailsPorRemetente.get(key).size()))
            .get();
    }

    
    // Parte da letra e: assunto preferido de um conjunto de funcionarios identificados por seus emails
    String assuntoPreferido(List<String> remetentes){
        // Seleciona os assuntos  dos emails que tem como remetente um dos emails da lista recebida
        List<String> assuntosDosEmailsDestesFuncionarios = carregadorDeEmails
            .emails()
            .stream()
            .filter(e->remetentes.contains(e.getEmailOrigem()))
            .map(Email::getSubject)
            .sorted()
            .collect(Collectors.toList());
            
        // Agrupa os assuntos contando as quantidades
        Map<String, Long> counts =
        assuntosDosEmailsDestesFuncionarios
            .stream()
            .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        // Identifica qual assunto ocorre mais vezes
        long qtdade = 0;
        String assuntoMaisFreq = "";
        for(String assunto:counts.keySet()){
            if (qtdade < counts.get(assunto)){
                qtdade = counts.get(assunto);
                assuntoMaisFreq = assunto;
            }
        }
        return assuntoMaisFreq;
    }
    
}
