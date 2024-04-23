package com.example.demo;

import edu.gemini.app.ocs.model.ObservingProgram;
import edu.gemini.app.ocs.model.ObservingProgramConfigs;
import edu.gemini.app.ocs.model.TelePositionPair;
import jakarta.persistence.*;


@Entity
@Table(name = "ObservingPrograms")
public class ObservingPrograms extends ObservingProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ObservingProgramConfigs.FoldMirrorType scienceFoldMirrorType;

    @Enumerated(EnumType.STRING)
    private ObservingProgramConfigs.CalibrationUnit calibrationUnit;

    @Enumerated(EnumType.STRING)
    private ObservingProgramConfigs.LightType lightType;

    @Transient
    private TelePositionPair[] telePositionPairs;

    private boolean validationStatus;

    private String errorMessage;

    public ObservingPrograms() {
        super();
    }

    public ObservingPrograms(int planNo, String opticsPrimary, double fStop, double opticsSecondaryRMS, double scienceFoldMirrorDegree,
                             ObservingProgramConfigs.FoldMirrorType scienceFoldMirrorType, int moduleContent,
                             ObservingProgramConfigs.CalibrationUnit calibrationUnit, ObservingProgramConfigs.LightType lightType,
                             TelePositionPair[] telePositionPairs) {
        super(planNo, opticsPrimary, fStop, opticsSecondaryRMS, scienceFoldMirrorDegree, scienceFoldMirrorType, moduleContent, calibrationUnit, lightType, telePositionPairs);
        this.scienceFoldMirrorType = scienceFoldMirrorType;
        this.calibrationUnit = calibrationUnit;
        this.lightType = lightType;
        this.telePositionPairs = telePositionPairs;
        this.validationStatus = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ObservingProgramConfigs.FoldMirrorType getScienceFoldMirrorType() {
        return scienceFoldMirrorType;
    }

    public void setScienceFoldMirrorType(ObservingProgramConfigs.FoldMirrorType scienceFoldMirrorType) {
        this.scienceFoldMirrorType = scienceFoldMirrorType;
    }

    public ObservingProgramConfigs.CalibrationUnit getCalibrationUnit() {
        return calibrationUnit;
    }

    public void setCalibrationUnit(ObservingProgramConfigs.CalibrationUnit calibrationUnit) {
        this.calibrationUnit = calibrationUnit;
    }

    public ObservingProgramConfigs.LightType getLightType() {
        return lightType;
    }

    public void setLightType(ObservingProgramConfigs.LightType lightType) {
        this.lightType = lightType;
    }

    public TelePositionPair[] getTelePositionPairs() {
        return telePositionPairs;
    }

    public void setTelePositionPairs(TelePositionPair[] telePositionPairs) {
        this.telePositionPairs = telePositionPairs;
    }

    public boolean isValidationStatus() {
        return validationStatus;
    }

    public void setValidationStatus(boolean validationStatus) {
        this.validationStatus = validationStatus;
    }
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}