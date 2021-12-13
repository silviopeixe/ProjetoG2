package com.bcopstein;

public class Email {
    private String emailOrigem;
    private String emailDestino;
    private String subject;
    
    public Email(String emailOrigem, String emailDestino, String subject) {
        this.emailOrigem = emailOrigem;
        this.emailDestino = emailDestino;
        this.subject = subject;
    }

    public String getEmailOrigem() {
        return emailOrigem;
    }

    public String getEmailDestino() {
        return emailDestino;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "Email [emailDestino=" + emailDestino + ", emailOrigem=" + emailOrigem + ", subject=" + subject + "]";
    }
}
