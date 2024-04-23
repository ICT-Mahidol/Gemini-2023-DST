package com.example.demo;

import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.example.MySciencePlan;
import edu.gemini.app.ocs.model.AstronomicalData;
import edu.gemini.app.ocs.model.DataProcRequirement;
import edu.gemini.app.ocs.model.SciencePlan;

import edu.gemini.app.ocs.model.StarSystem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class CollectAstronomicalDataController {
    OCS ocs = new OCS(true);


    @CrossOrigin
    @GetMapping("/getCollectAstronomicalData")
    public String getCollectAstronomicalData(@RequestParam("id") int id, Model model) {

        // Example to test: http://localhost:8080/getCollectAstronomicalData?id=1
        //  Update a science plan status
        System.out.println("\nUpdate a science plan status");
        ocs.updateSciencePlanStatus(1, SciencePlan.STATUS.COMPLETE);
        ocs.updateSciencePlanStatus(2, SciencePlan.STATUS.COMPLETE);
        System.out.println("Make All Science Plan Completed to test get Astro data");

        System.out.println("\nGet the astronomical data from complete science plan");
        SciencePlan sciencePlan = ocs.getSciencePlanByNo(id); //define and get id
        //sample sp1
        SciencePlan sp1 = ocs.getSciencePlanByNo(1);
        //sample sp2
        SciencePlan sp2 = ocs.getSciencePlanByNo(2);
        System.out.println("\nScience Plab No. "+ sciencePlan);

        AstronomicalData astroData = null;
        AstronomicalData astro1 = null;
        AstronomicalData astro2 = null;
        try {
            // Retrieve astronomical data based on the retrieved science plan
            astroData = ocs.getAstronomicalData(sciencePlan);
            astro1 = ocs.getAstronomicalData(ocs.getSciencePlanByNo(1));
            astro2 = ocs.getAstronomicalData(ocs.getSciencePlanByNo(2));
            if (astroData != null) {

                ArrayList<BufferedImage> images = astroData.getAllImages(); //get Image info
                System.out.println("Astronomical Image Info: "+ images);
                ArrayList<String> URL = astroData.getAstronomicalDataLinks(); //get URL DataLinks = List of URL
                model.addAttribute("URL", URL); //Pass data to HTML Page
                System.out.println("IMAGE URL:" + URL);
                System.out.println("Images = " + URL.size());
//                System.out.println("Astronomical Data 1: " + astro1);
//                System.out.println("Astronomical Data 2: " + astro2);
            } else {
                System.out.println("No astronomical data collected for science plan with ID: " + id);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
        return "getAstronomicalData";
    }


}
