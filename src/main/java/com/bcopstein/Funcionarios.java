package com.bcopstein;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Funcionarios {
    private CarregadorDeFuncionarios funcionarios;

    public Funcionarios(CarregadorDeFuncionarios dados){
        this.funcionarios = dados;
        dados.carregaDados();
    }

    public Funcionario get(String email){
        Funcionario funcionario = funcionarios.get(email);
        if (funcionario == null){
            throw new IllegalArgumentException("Email inexistente: ["+email+"]");
        }
        return funcionario;
    }

    // Emails dos funcionarios de determinado sexo
    public List<String> emailsDosFuncionariosDoSexo(String sexo){
       // Cria um dicionário dos funcionarios por sexo
       Map<String,List<Funcionario>> funcionariosPorSexo = funcionarios
       .funcionarios()
       .stream()
       .collect(Collectors.groupingBy(e->e.getGender()));
       // Retorna os emails dos funcionarios do sexo selecionado
       return funcionariosPorSexo.get(sexo)
                .stream()
                .map(f->f.geteMail())
                .collect(Collectors.toList());
    }


}
