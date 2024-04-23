package com.gemini.pj.phase2.model;

import edu.gemini.app.ocs.model.AstronomicalData;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

@Entity
@Table(name = "Observer")
public class Observer extends User {
    public Observer() { }
    public Observer(int userId, String userUsername, String userPassword, String userPermission, String userAccountName) {
        super(userId, userUsername, userPassword, userPermission, userAccountName);
    }
    public ArrayList<BufferedImage> getAstronomicalData(int id){
        System.out.println(ocs.getSciencePlanByNo(id));
        AstronomicalData astroData = null;
        try {
            astroData = ocs.getAstronomicalData(ocs.getSciencePlanByNo(id));
            if (astroData != null) {
                ArrayList<BufferedImage> images = null;
                images = astroData.getAllImages();
                return images;
            }else {
                System.out.println("No astronomical data collected.\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}

