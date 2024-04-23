package com.example.demo.model;


public class TelescopeOperator extends User {
    private String TelescopeOperatorID;

    public TelescopeOperator(String username, String password, String email, String phoneNumber, String role, String telescopeOperatorID) {
        super(username, password, email, phoneNumber, role);
        this.TelescopeOperatorID = telescopeOperatorID ;
    }

    // Getter and setter methods for astronomerID
    public String getTelescopeOperatorID() {
        return TelescopeOperatorID;
    }

    public void setTelescopeOperatorID(String telescopeOperatorID) {
        this.TelescopeOperatorID = telescopeOperatorID;
    }
}