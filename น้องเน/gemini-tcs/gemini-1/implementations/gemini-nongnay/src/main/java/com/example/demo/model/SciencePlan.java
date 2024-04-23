package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "science_plans")
public class SciencePlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int planNo;

    @Column(name = "creator")
    private String creator;

    @Column(name = "submitter")
    private String submitter;

    @Column(name = "funding_inusd")
    private double fundingInUSD;

    @Column(name = "objectives", columnDefinition = "TEXT")
    private String objectives;

    @Column(name = "star_system")
    private String starSystem;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "telescope_location")
    private String telescopeLocation;

    @Column(name = "status")
    private String status;

    // Standard getters and setters

    public int getPlanNo() {
        return planNo;
    }

    public void setPlanNo(int planNo) {
        this.planNo = planNo;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public double getFundingInUSD() {
        return fundingInUSD;
    }

    public void setFundingInUSD(double fundingInUSD) {
        this.fundingInUSD = fundingInUSD;
    }

    public String getObjectives() {
        return objectives;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    public String getStarSystem() {
        return starSystem;
    }

    public void setStarSystem(String starSystem) {
        this.starSystem = starSystem;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTelescopeLocation() {
        return telescopeLocation;
    }

    public void setTelescopeLocation(String telescopeLocation) {
        this.telescopeLocation = telescopeLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
