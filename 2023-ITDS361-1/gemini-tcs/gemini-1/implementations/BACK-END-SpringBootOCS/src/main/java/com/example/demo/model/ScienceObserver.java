package com.example.demo.model;


public class ScienceObserver extends User {
    private String ScienceObserverID;

    public ScienceObserver(String username, String password, String email, String phoneNumber, String role, String scienceObserverID) {
        super(username, password, email, phoneNumber, role);
        this.ScienceObserverID = scienceObserverID ;
    }

    public String getScienceObserverID() {
        return ScienceObserverID;
    }

    public void setScienceObserverID(String scienceObserverID) {
        this.ScienceObserverID = scienceObserverID;
    }
}