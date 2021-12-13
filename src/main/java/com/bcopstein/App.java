package com.bcopstein;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Emails emails = new Emails(new CarregadorDeEmails());
        Funcionarios funcionarios = new Funcionarios(new CarregadorDeFuncionarios());
        
        System.out.print("\na) Conjunto de assuntos:");
        System.out.println(emails.assuntos());

        System.out.print("b) Assunto mais frequente e frequencia:");
        String[] resposta = emails.assuntoMaisFrequente();
        System.out.println(resposta[0]+", "+resposta[1]);

        System.out.print("c) Remetente que mais enviou mensagens sobre "+resposta[0]+":");
        String emailRemetente = emails.remetenteQueMaisEnviouEmailAssunto(resposta[0]);
        System.out.println(funcionarios.get(emailRemetente).getFirstName());

        System.out.print("d) Assunto preferido das mulheres:");
        List<String> remetentesMulheres = funcionarios.emailsDosFuncionariosDoSexo("feminino");
        String assuntoPref = emails.assuntoPreferido(remetentesMulheres);
        System.out.println(assuntoPref);
    }
}



