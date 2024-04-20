package com.example.gemini.Model;

import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.model.*;
import jakarta.persistence.*;

import java.util.Arrays;

//Pattern design == Adapter
@Entity
@Table(name = "observing_program")
public class ObservingProgramModelGDDG extends ObservingProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id") // กำหนดชื่อ column
    private Integer id;
    // Attributes from ObservingProgram
    private int planNo;
    private String geminiLocation;
    private String opticsPrimary;
    private double fStop;
    private double opticsSecondaryRMS;
    private double scienceFoldMirrorDegree;

    @Enumerated(EnumType.STRING)
    private ObservingProgramConfigs.FoldMirrorType scienceFoldMirrorType;

    private int moduleContent;

    @Enumerated(EnumType.STRING)
    private ObservingProgramConfigs.CalibrationUnit calibrationUnit;

    @Enumerated(EnumType.STRING)
    private ObservingProgramConfigs.LightType lightType;
    @Transient
    private TelePositionPair[] telePositionPairs;
    private boolean validationStatus;

    public ObservingProgramModelGDDG(int planNo, String opticsPrimary, double fStop, double opticsSecondaryRMS, ObservingProgramConfigs.FoldMirrorType foldMirrorType, int moduleContent, ObservingProgramConfigs.CalibrationUnit calibrationUnit, ObservingProgramConfigs.LightType lightType, TelePositionPair[] telePositionPairs) {
    }

    public ObservingProgramModelGDDG(SciencePlanModelGDDG myplanNo, String opticsPrimary, double fStop, double opticsSecondaryRMS, ObservingProgramConfigs.FoldMirrorType foldMirrorType, int moduleContent, ObservingProgramConfigs.CalibrationUnit calibrationUnit, ObservingProgramConfigs.LightType lightType, TelePositionPair[] telePositionPairs) {
    }

    public TelePositionPair[] getTelePositionPairs() {
        return telePositionPairs;
    }

    public void setTelePositionPairs(TelePositionPair[] telePositionPairs) {
        this.telePositionPairs = telePositionPairs;
    }
    // Constructor, getters, setters, and other methods


    public ObservingProgramModelGDDG() {
    }

    public ObservingProgramModelGDDG(int planNo, String opticsPrimary, double fStop, double opticsSecondaryRMS, double scienceFoldMirrorDegree, ObservingProgramConfigs.FoldMirrorType scienceFoldMirrorType, int moduleContent, ObservingProgramConfigs.CalibrationUnit calibrationUnit, ObservingProgramConfigs.LightType lightType, TelePositionPair[] telePositionPair) {
        this.planNo = planNo;
        this.geminiLocation = "";
        this.opticsPrimary = opticsPrimary;
        this.fStop = fStop;
        this.opticsSecondaryRMS = opticsSecondaryRMS;
        this.scienceFoldMirrorDegree = scienceFoldMirrorDegree;
        this.moduleContent = moduleContent;
        this.calibrationUnit = calibrationUnit;
        this.lightType = lightType;
        this.setTelePositionPair(telePositionPair);
        this.setValidationStatus(false);
    }
@Override
    public int getPlanNo() {
        return this.planNo;
    }
    @Override
    public void setPlanNo(int planNo) {
        this.planNo = planNo;
    }
    @Override
    public String getGeminiLocation() {
        return this.geminiLocation;
    }
    @Override
    public void setGeminiLocation(String geminiLocation) {
        this.geminiLocation = geminiLocation;
    }
    @Override
    public String getOpticsPrimary() {
        return this.opticsPrimary;
    }
    @Override
    public void setOpticsPrimary(String opticsPrimary) {
        this.opticsPrimary = opticsPrimary;
    }
    @Override
    public double getfStop() {
        return this.fStop;
    }
    @Override
    public void setfStop(double fStop) {
        this.fStop = fStop;
    }
    @Override
    public double getOpticsSecondaryRMS() {
        return this.opticsSecondaryRMS;
    }
    @Override
    public void setOpticsSecondaryRMS(double opticsSecondaryRMS) {
        this.opticsSecondaryRMS = opticsSecondaryRMS;
    }
    @Override
    public double getScienceFoldMirrorDegree() {
        return this.scienceFoldMirrorDegree;
    }
    @Override
    public void setScienceFoldMirrorDegree(double scienceFoldMirrorDegree) {
        this.scienceFoldMirrorDegree = scienceFoldMirrorDegree;
    }
    @Override
    public ObservingProgramConfigs.FoldMirrorType getScienceFoldMirrorType() {
        return this.scienceFoldMirrorType;
    }
    @Override
    public void setScienceFoldMirrorType(ObservingProgramConfigs.FoldMirrorType scienceFoldMirrorType) {
        this.scienceFoldMirrorType = scienceFoldMirrorType;
    }
    @Override
    public int getModuleContent() {
        return this.moduleContent;
    }
    @Override
    public void setModuleContent(int moduleContent) {
        this.moduleContent = moduleContent;
    }
    @Override
    public ObservingProgramConfigs.CalibrationUnit getCalibrationUnit() {
        return this.calibrationUnit;
    }
    @Override
    public void setCalibrationUnit(ObservingProgramConfigs.CalibrationUnit calibrationUnit) {
        this.calibrationUnit = calibrationUnit;
    }
    @Override
    public ObservingProgramConfigs.LightType getLightType() {
        return this.lightType;
    }
    @Override
    public void setLightType(ObservingProgramConfigs.LightType lightType) {
        this.lightType = lightType;
    }
    @Override
    public TelePositionPair[] getTelePositionPair() {
        return this.telePositionPairs; // ส่งค่าของตัวแปร telePositionPairs ออกไป
    }
    @Override
    public void setTelePositionPair(TelePositionPair[] telePositionPair) {
        this.telePositionPairs = telePositionPair; // อัปเดตค่าของตัวแปร telePositionPairs
    }

    @Override
    public boolean getValidationStatus() {
        return this.validationStatus;
    }
    @Override
    public void setValidationStatus(boolean validationStatus) {
        this.validationStatus = validationStatus;
    }
    @Override
    public ObservingProgram validateObservingCondition(ObservingProgram op) {
        String opticPriGN = "GNZ";
        String opticPriGS = "GSZ";
        double fStopGNMin = 1.8;
        double fStopGNMax = 8.1;
        double fStopGSMin = 2.9;
        double fStopGSMax = 18.0;
        double opticSecNMin = 5.0;
        double opticSecNMax = 17.0;
        double opticSecSMin = 5.0;
        double opticSecSMax = 13.0;
        double sciFoldDegreeMin = 30.0;
        double sciFoldDegreeMax = 45.0;
        double movDirMin = 0.0;
        double movDirMax = 360.0;
        double movDegMin = 0.0;
        double movDegMax = 70.0;
        boolean validStatus = false;
        String geminiLoc = op.getGeminiLocation();
        String errMsg = "";
        String opticPriValue = op.getOpticsPrimary();
        double opticSecRMS = op.getOpticsSecondaryRMS();
        double fStopValue = op.getfStop();
        double scienceFoldValue = op.getScienceFoldMirrorDegree();
        if (!"GNZ".equals(opticPriValue) && !"GSZ".equals(opticPriValue)) {
            validStatus = false;
            errMsg = "OpticPrimary is not correct.";
        } else if (opticPriValue.equals("GNZ")) {
            if (fStopValue >= 1.8 && fStopValue <= 8.1) {
                validStatus = true;
                errMsg = "Validate: true";
            } else {
                validStatus = false;
                errMsg = "f-stop out of range.";
            }
        } else if (fStopValue >= 2.9 && fStopValue <= 18.0) {
            validStatus = true;
            errMsg = "Validate: true";
        } else {
            validStatus = false;
            errMsg = "f-stop out of range.";
        }

        if (validStatus) {
            if (geminiLoc == "N") {
                if (opticSecRMS >= 5.0 && opticSecRMS <= 17.0) {
                    validStatus = true;
                    errMsg = "Validate: true";
                } else {
                    validStatus = false;
                    errMsg = "OpticsSecondary(rms surface) out of range.";
                }
            } else if (opticSecRMS >= 5.0 && opticSecRMS <= 13.0) {
                validStatus = true;
                errMsg = "Validate: true";
            } else {
                validStatus = false;
                errMsg = "OpticsSecondary(rms surface) out of range.";
            }
        }

        if (validStatus) {
            if (scienceFoldValue >= 30.0 && scienceFoldValue <= 45.0) {
                validStatus = true;
                errMsg = "Validate: true";
            } else {
                validStatus = false;
                errMsg = "Science Fold Mirror degree out of range.";
            }
        }

        if (validStatus) {
            TelePositionPair[] telePositionPairs = op.getTelePositionPair();
            TelePositionPair[] var43 = telePositionPairs;
            int var44 = telePositionPairs.length;

            for(int var45 = 0; var45 < var44; ++var45) {
                TelePositionPair tp = var43[var45];
                if (!(tp.getDirection() >= 0.0) || !(tp.getDirection() <= 360.0)) {
                    validStatus = false;
                    errMsg = "Direction out of range.";
                    break;
                }

                if (!(tp.getDegree() <= 70.0)) {
                    validStatus = false;
                    errMsg = "Degree out of range.";
                    break;
                }

                validStatus = true;
                errMsg = "Validate: true";
            }
        }

        if (validStatus) {
            op.setValidationStatus(true);
        } else {
            op.setValidationStatus(false);
        }

        System.out.println(errMsg);
        return op;
    }

}

