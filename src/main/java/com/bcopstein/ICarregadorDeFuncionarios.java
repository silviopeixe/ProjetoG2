package com.bcopstein;

import java.util.Collection;
import java.util.Set;

public interface ICarregadorDeFuncionarios{
    void carregaDados();
    Set<String> chaves();
    Collection<Funcionario> funcionarios();
    Funcionario get(String chave);
}
