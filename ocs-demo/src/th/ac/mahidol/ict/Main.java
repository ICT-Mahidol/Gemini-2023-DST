package th.ac.mahidol.ict;

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

        // Case 1: Get all the science plans
        System.out.println("\nCase 1: Get all the science plans");
        ArrayList<SciencePlan> sciencePlans = ocs.getAllSciencePlans();
        for (SciencePlan sp : sciencePlans) {
            System.out.println(sp);
        }
        // Case 2: Get a science plan by ID
        System.out.println("\nCase 2: Get a science plan by ID");
        SciencePlan sp2 = ocs.getSciencePlanByNo(2);
        System.out.println(sp2);

        // Case 3: Create a new science plan
        System.out.println("\nCase 3: Create a new science plan");
        MySciencePlan mySP = new MySciencePlan();
        mySP.setCreator("Morakot Choetkiertikul");
        mySP.setSubmitter("Chaiyong Ragkhitwetsagul");
        mySP.setFundingInUSD(1000);
        mySP.setObjectives("To study the Auriga star system.");
        mySP.setStarSystem(StarSystem.CONSTELLATIONS.Auriga);
        mySP.setStartDate("22/04/2021 23:00:00");
        mySP.setTelescopeLocation(SciencePlan.TELESCOPELOC.CHILE);
        mySP.setEndDate("23/04/2021 02:00:00");
        DataProcRequirement dpr1 =
                new DataProcRequirement("JPEG", "Low", "Color mode",
                        11, 10, 5, 0, 7, 0,
                        0, 0, 10, 8);
        mySP.setDataProcRequirements(dpr1);
        // submit it to the OCS system
        ocs.createSciencePlan(mySP);
        System.out.println(ocs.getAllSciencePlans());

        // Case 4: Update a science plan status
        System.out.println("\nCase 4: Update a science plan status");
        ocs.updateSciencePlanStatus(3, SciencePlan.STATUS.COMPLETE);
        System.out.println(ocs.getSciencePlanByNo(3));

        // Case 5: Get the astronomical data from complete science plan
        System.out.println("\nCase 5: Get the astronomical data from complete science plan");
        System.out.println(ocs.getSciencePlanByNo(3));
        AstronomicalData astroData = null;
        try {
            astroData = ocs.getAstronomicalData(ocs.getSciencePlanByNo(3));
            if (astroData != null) {
                ArrayList<BufferedImage> images = null;
                images = astroData.getAllImages();
                for (BufferedImage img : images) {
                    try {
                        JFrame frame = new JFrame();
                        frame.getContentPane().setLayout(new FlowLayout());
                        frame.getContentPane().add(new JLabel(new ImageIcon(img)));
                        frame.pack();
                        frame.setVisible(true);
                        // if you want the X button to close the app
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    } catch (NullPointerException e) {
                        System.out.println("There's a problem getting the image's content. Skip.");
                        continue;
                    }
                }
                System.out.println("Images = " + images.size());
            } else {
                System.out.println("No astronomical data collected.\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Case 6: Remove a science plan
        System.out.println("\nCase 6: Remove a science plan");
        ocs.deleteSciencePlanByNo(3);
        System.out.println(ocs.getAllSciencePlans());

        // Case 7: Execute a command line
        System.out.println("\nCase 7: Execute a Gemini command line's command");
        // Execute the command to get the Gemini system version
        System.out.println(ocs.executeCommand("GetVersion"));
        // Execute the command to get the status of the Gemini system
        System.out.println(ocs.executeCommand("GetStatus"));
        // Execute the command to run the system test
        System.out.println(ocs.executeCommand("RunTest"));
        // Send command to the virtual telescope
        System.out.println(ocs.executeCommand("START"));
        System.out.println(ocs.executeCommand("UP"));
        System.out.println(ocs.executeCommand("UP"));
        System.out.println(ocs.executeCommand("LEFT"));
        System.out.println(ocs.executeCommand("LEFT"));
        System.out.println(ocs.executeCommand("FOCUS"));
        System.out.println(ocs.executeCommand("TAKE_PHOTO"));
        System.out.println(ocs.executeCommand("STOP"));
        // Execute an unavailable command
        System.out.println(ocs.executeCommand("A"));

        // Case 8: Install and remove the physical units in the operation tables
        System.out.println("\nCase 8: Install and remove the physical units in the operation tables");
        System.out.println("OPERATING TABLE");
        System.out.println(ocs.getConfigurations());
        boolean success = ocs.addConfiguration("My Own Physical Unit");
        System.out.println("Adding status: " + success);
        System.out.println(ocs.getConfigurations());
        success = ocs.removeConfiguration(5);
        System.out.println("Removing status: " + success);
        System.out.println(ocs.getConfigurations());

        // Case 9: Access live view of telescope
        System.out.println("\nCase 9: Access live view of telescope");
        try {
            System.out.println(ocs.accessTelescopeLiveView());
        } catch (IOException ie) {
            ie.printStackTrace();
        }

        // Case 10: Test science plan
        System.out.println("\nCase 10: Test a science plan");
        System.out.println(ocs.testSciencePlan(ocs.getSciencePlanByNo(2)));
        System.out.println(ocs.getAllSciencePlans());

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

        // Case 12: manage observation schedule
        System.out.println("\nCase 12: manage observation schedule");
        Calendar cal = Calendar.getInstance();
        cal.set(2023, 11, 21);
        Date date = cal.getTime();
        System.out.println(ocs.addUnavailableDate(date));
        System.out.println(ocs.deleteUnavailableDate(date));
        System.out.println(ocs.getAllObservationSchedule());

        // Case 13: remove astronomical data
        System.out.println("\nCase 13: Remove an astronomical data");
        try {
            astroData = ocs.removeAstronomicalData(ocs.getSciencePlanByNo(1),0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
