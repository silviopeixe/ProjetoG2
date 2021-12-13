package com.bcopstein;

import java.util.Collection;

public interface ICarregadorDeEmails {
    void carregaDados();
    Collection<Email> emails();
}
