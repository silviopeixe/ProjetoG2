package com.bcopstein;

public class Funcionario {
    private int id;
    private String firstName;
    private String lastName;
    private String eMail;
    private String gender;
    
    public Funcionario(int id, String firstName, String lastName, String eMail, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Funcionario [eMail=" + eMail + ", firstName=" + firstName + ", gender=" + gender + ", id=" + id
                + ", lastName=" + lastName + "]";
    }
}
