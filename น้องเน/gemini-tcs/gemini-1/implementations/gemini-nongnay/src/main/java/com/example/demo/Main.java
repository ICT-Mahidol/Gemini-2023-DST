package com.example.demo;

import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.example.MySciencePlan;
import edu.gemini.app.ocs.model.*;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        //        OCS ocs = new OCS();
        OCS ocs = new OCS(true);
        MySciencePlan mySP = new MySciencePlan();
        ArrayList<SciencePlan> sciencePlans = ocs.getAllSciencePlans();
        // Case 11: Create observing program
        System.out.println("\nCase 11: Create an observing program");
        ObservingProgramConfigs.FoldMirrorType[] foldMirrorTypes = ObservingProgramConfigs.getFoldMirrorType();
        ObservingProgramConfigs.CalibrationUnit[] calibrationunits = ObservingProgramConfigs.getCalibrationUnit();
        ObservingProgramConfigs.LightType[] lightTypes = ObservingProgramConfigs.getLightType();
        TelePositionPair[] telePositionPairs = new TelePositionPair[5];
        TelePositionPair telePositionPair1 = new TelePositionPair(35.0, 40.0);
        telePositionPairs[0] = telePositionPair1;
        TelePositionPair telePositionPair2 = new TelePositionPair(50.0, 60.0);
        telePositionPairs[1] = telePositionPair2;
        TelePositionPair telePositionPair3 = new TelePositionPair(80.0, 15.0);
        telePositionPairs[2] = telePositionPair3;
        TelePositionPair telePositionPair4 = new TelePositionPair(90.0, 10.0);
        telePositionPairs[3] = telePositionPair4;
        TelePositionPair telePositionPair5 = new TelePositionPair(20.0, 20.0);
        telePositionPairs[4] = telePositionPair5;

        ObservingProgram op = ocs.createObservingProgram(mySP, "GNZ",
                1.9, 7, 33, foldMirrorTypes[0],
                2, calibrationunits[1], lightTypes[1], telePositionPairs);
        System.out.println(op);
        op.validateObservingCondition(op);
        System.out.println(op);
        ocs.saveObservingProgram(op);

        sciencePlans = ocs.getAllSciencePlans();

        for (SciencePlan sp : sciencePlans) {
            System.out.println(sp);
            System.out.println(ocs.getObservingProgramBySciencePlan(sp));
        }
    }
}