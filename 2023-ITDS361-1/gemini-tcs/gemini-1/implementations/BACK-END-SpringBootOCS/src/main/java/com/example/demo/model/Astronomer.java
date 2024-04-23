package com.example.demo.model;


public class Astronomer extends User {
    private String astronomerID;

    public Astronomer(String username, String password, String email, String phoneNumber, String role, String astronomerID) {
        super(username, password, email, phoneNumber, role);
        this.astronomerID = astronomerID ;
    }

    // Getter and setter methods for astronomerID
    public String getAstronomerID() {
        return astronomerID;
    }

    public void setAstronomerID(String astronomerID) {
        this.astronomerID = astronomerID;
    }
}