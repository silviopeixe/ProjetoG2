package com.bcopstein;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FuncionarioTest {
    private int id;
    private String firstName;
    private String lastName;
    private String eMail;
    private String gender;
    private Funcionario funcionario;

    @BeforeEach
    void setup(){
        id = 1;
        firstName = "Silvio";
        lastName = "Costa";
        eMail = "silvio.costa@pucrs.br";
        gender = "masculino";
        funcionario = new Funcionario(id,firstName,lastName,eMail,gender);
    }

    @Test
    void testarconstrutor(){

        assertEquals(id, funcionario.getId());
        assertEquals(firstName, funcionario.getFirstName());
        assertEquals(lastName, funcionario.getLastName());
        assertEquals(eMail, funcionario.geteMail());
        assertEquals(gender, funcionario.getGender());
    }

    @Test
    void toStringTest(){
        String esperada = "Funcionario [eMail=" + eMail + ", firstName=" + firstName + ", gender=" + gender + ", id=" + id + ", lastName=" + lastName + "]";
        assertEquals(esperada, funcionario.toString());
    }
}
