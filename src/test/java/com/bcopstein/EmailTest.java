package com.bcopstein;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmailTest {
    private String emailOrigiem;
    private String emailDestino;
    private String subject;
    private Email email;

    @BeforeEach
    void setup(){
        emailOrigiem = "teste@terra.com.br";
        emailDestino = "destino@uol.com.br";
        subject = "teste";
        email = new Email(emailOrigiem,emailDestino,subject);
    }

    @Test
    void testconstrutor(){
        assertEquals(emailOrigiem, email.getEmailOrigem());
        assertEquals(emailDestino, email.getEmailDestino());
        assertEquals(subject, email.getSubject());

    }

    @Test
    void toStringTest(){
        String esperada = "Email [emailDestino=" + emailDestino + ", emailOrigem=" + emailOrigiem + ", subject=" + subject + "]";
        assertEquals(esperada, email.toString());
    }

}
