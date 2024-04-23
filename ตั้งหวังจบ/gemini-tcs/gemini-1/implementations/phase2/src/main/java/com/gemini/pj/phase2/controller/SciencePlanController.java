package com.gemini.pj.phase2.controller;

import edu.gemini.app.ocs.model.*;
import com.gemini.pj.phase2.model.*;
import com.gemini.pj.phase2.model.Observer;
import com.gemini.pj.phase2.repository.UserRepository;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

@Controller
public class SciencePlanController {
    @Autowired
    private UserRepository userRepository;

    @CrossOrigin
    @GetMapping("scienceplans")
    public @ResponseBody
    ArrayList<SciencePlan> getAllSciencePlan(@RequestParam(value = "id") int id) {
        User user = (User) userRepository.findById(id).get();
        return user.getAllSciencePlan();
    }

    @CrossOrigin
    @GetMapping("scienceplan")
    public @ResponseBody
    SciencePlan getSciencePlanByID(@RequestParam(value = "id") int id,@RequestParam(value = "planNo") int planNo) {
        User user = (User) userRepository.findById(id).get();
        return user.getSciencePlanByID(planNo);
    }

    @CrossOrigin
    @PostMapping("scienceplans")
    public @ResponseBody
    String addSciencePlan(@RequestBody Map<String, Object> body,@RequestParam(value = "id") int id){
        Astronomer astronomer = (Astronomer) userRepository.findById(id).get();
        SciencePlan newSc = astronomer.createSciencePlan(body);
        return "Successfully Created a new science plan" + newSc.toString();
    }
    @CrossOrigin
    @GetMapping("testscienceplan")
    public @ResponseBody String testSciencePlan(@RequestParam(value = "id") int id,@RequestParam(value = "sciplan") int sciplan) {
        System.out.println(id+sciplan);
        Astronomer astronomer = (Astronomer) userRepository.findById(id).get();
        SciencePlan sc = astronomer.getSciencePlanByID(sciplan);
        return astronomer.testSciencePlan(sc);
    }
    @CrossOrigin
    @GetMapping("starsystems")
    public @ResponseBody
    ArrayList<StarSystem.CONSTELLATIONS> getAllStarSystem(@RequestParam(value = "id") int id) {
        Astronomer astronomer = (Astronomer) userRepository.findById(id).get();
        return astronomer.getAllStarSystem();
    }
    @CrossOrigin
    @GetMapping("telescopelocations")
    public @ResponseBody
    ArrayList<SciencePlan.TELESCOPELOC> getAllTelescopeLoc(@RequestParam(value = "id") int id) {
        Astronomer astronomer = (Astronomer) userRepository.findById(id).get();
        return astronomer.getAllTelescopeLoc();
    }

    @CrossOrigin
    @GetMapping("getastronomicaldata")
    public @ResponseBody
        ArrayList<String> getAstronomicalData(@RequestParam(value = "id") int id, @RequestParam(value = "planNo") int planNo) {
        Observer observer = (Observer) userRepository.findById(id).get();

        ArrayList<BufferedImage> images = observer.getAstronomicalData(planNo);
        if (images == null){
            ArrayList<String> result = new ArrayList<String>();
            result.add("No astronomical data collected.");
            return result;
        }

        ArrayList<String> encodedImages = new ArrayList<>();
        for (BufferedImage image : images) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
                ImageIO.write(image, "jpg", baos);
                String encodedImage = Base64.getEncoder().encodeToString(baos.toByteArray());
                encodedImages.add(encodedImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return encodedImages;
    }
    @CrossOrigin
    @GetMapping("setsciplanstatus")
    public @ResponseBody
        String setSciencePlanStatus(@RequestParam(value = "id") int id,@RequestParam(value = "planNo") int planNo, @RequestParam(value = "status") String status){
        User user = (User) userRepository.findById(id).get();
        Boolean result = user.updateSciencePlanStatus(planNo, status);
        if (result) return "Science plan status has been updated";
        return "Error, Cannot Update Status";

    }

}
