package com.gemini.pj.phase2.model;

import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.model.SciencePlan;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity

@Table(name="USER")
public abstract class User {
    @Id
    private int userId;
    public String userUsername;
    private String userPassword;
    private String userPermission;
    private String userAccountName;

    static OCS ocs = new OCS(true);

    protected User(){  }

    public User(int userId, String userUsername, String userPassword, String userPermission, String userAccountName) {
        this.userId = userId;
        this.userUsername = userUsername;
        this.userPassword = userPassword;
        this.userPermission = userPermission;
        this.userAccountName = userAccountName;
    }

    public int login(String username, String password) {
        if(this.userUsername.equals(username) && this.userPassword.equals(password)) {
            return this.userId;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userUsername='" + userUsername + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPermission='" + userPermission + '\'' +
                ", userAccountName='" + userAccountName + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPermission() {
        return userPermission;
    }

    public void setUserPermission(String userPermission) {
        this.userPermission = userPermission;
    }

    public String getUserAccountName() {
        return userAccountName;
    }

    public void setUserAccountName(String userAccountName) {
        this.userAccountName = userAccountName;
    }

    public ArrayList<SciencePlan> getAllSciencePlan(){
        System.out.println("Getting all SciencePlan");
        for(SciencePlan sc : ocs.getAllSciencePlans()){
            System.out.println(sc);
        }
        return ocs.getAllSciencePlans();
    }

    public SciencePlan getSciencePlanByID(int id){
        for(SciencePlan sc : ocs.getAllSciencePlans()){
            if(sc.getPlanNo() == id) return sc;
        }
        return null;
    }
    public boolean updateSciencePlanStatus(int id, String status){
        return ocs.updateSciencePlanStatus(id, SciencePlan.STATUS.valueOf(status));
    }
}
