package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "observing_programs")
public class ObservingProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "optics_primary", nullable = false)
    private String opticsPrimary;

    @Column(name = "f_stop", nullable = false)
    private double fStop;

    @Column(name = "optics_secondary_rms", nullable = false)
    private double opticsSecondaryRMS;

    @Column(name = "science_fold_mirror_degree", nullable = false)
    private double scienceFoldMirrorDegree;

    @Column(name = "module_content", nullable = false)
    private String moduleContent;

    @Column(name = "calibration_unit", nullable = false)
    private String calibrationUnit;

    @Column(name = "light_type", nullable = false)
    private String lightType;

    @Column(name = "tele_position_pairs", nullable = false)
    private String telePositionPairs;

    public ObservingProgram() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpticsPrimary() {
        return opticsPrimary;
    }

    public void setOpticsPrimary(String opticsPrimary) {
        this.opticsPrimary = opticsPrimary;
    }

    public double getfStop() {
        return fStop;
    }

    public void setfStop(double fStop) {
        this.fStop = fStop;
    }

    public double getOpticsSecondaryRMS() {
        return opticsSecondaryRMS;
    }

    public void setOpticsSecondaryRMS(double opticsSecondaryRMS) {
        this.opticsSecondaryRMS = opticsSecondaryRMS;
    }

    public double getScienceFoldMirrorDegree() {
        return scienceFoldMirrorDegree;
    }

    public void setScienceFoldMirrorDegree(double scienceFoldMirrorDegree) {
        this.scienceFoldMirrorDegree = scienceFoldMirrorDegree;
    }

    public String getCalibrationUnit() {
        return calibrationUnit;
    }

    public void setCalibrationUnit(String calibrationUnit) {
        this.calibrationUnit = calibrationUnit;
    }

    public String getLightType() {
        return lightType;
    }

    public void setLightType(String lightType) {
        this.lightType = lightType;
    }

    public String getModuleContent() {
        return moduleContent;
    }

    public void setModuleContent(String moduleContent) {
        this.moduleContent = moduleContent;
    }

    public String getTelePositionPairs() {
        return telePositionPairs;
    }

    public void setTelePositionPairs(String telePositionPairs) {
        this.telePositionPairs = telePositionPairs;
    }

    @Column(name = "validation_status")
    private boolean validationStatus=false;

    public boolean getValidationStatus() {
        return validationStatus;
    }

    public void setValidationStatus(boolean validationStatus) {
        this.validationStatus = validationStatus;
    }
}
