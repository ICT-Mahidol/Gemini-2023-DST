package com.example.demo;

import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.model.ObservingProgram;
import edu.gemini.app.ocs.model.ObservingProgramConfigs;
import edu.gemini.app.ocs.model.SciencePlan;
import edu.gemini.app.ocs.model.TelePositionPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ObservingProgramController {
    @GetMapping("/createObservingProgram")
    public String showObservingProgramForm(Model model) {
        model.addAttribute("observingProgram", new ObservingProgram());
        model.addAttribute("foldMirrorTypes", ObservingProgramConfigs.getFoldMirrorType());
        model.addAttribute("calibrationUnits", ObservingProgramConfigs.getCalibrationUnit());
        model.addAttribute("lightTypes", ObservingProgramConfigs.getLightType());
        model.addAttribute("telePositionPair", new TelePositionPair(0.0, 0.0));
        return "observing_program_form";
    }

    @PostMapping("/saveObservingProgram")
    public String saveObservingProgram(@ModelAttribute("observingProgram") ObservingProgram observingProgram,
                                       @RequestParam("teleDirection") List<Double> teleDirections,
                                       @RequestParam("teleDegree") List<Double> teleDegrees) {

        System.out.println("test fStop");
        System.out.println(observingProgram.getfStop());
        TelePositionPair[] telePositionPairs = new TelePositionPair[teleDirections.size()];


        if (teleDirections.size() != teleDegrees.size()) {
            return "error";
        }


        for (int i = 0; i < teleDirections.size(); i++) {
            double direction = teleDirections.get(i);
            double degree = teleDegrees.get(i);
            telePositionPairs[i] = new TelePositionPair(direction, degree);
        }

        OCS o = new OCS();
        SciencePlan sp = o.getSciencePlanByNo(observingProgram.getPlanNo());
        ObservingProgram op = o.createObservingProgram(sp, observingProgram.getOpticsPrimary(), observingProgram.getfStop(), observingProgram.getOpticsSecondaryRMS(),
                observingProgram.getScienceFoldMirrorDegree(), observingProgram.getScienceFoldMirrorType(), observingProgram.getModuleContent(),
                observingProgram.getCalibrationUnit(), observingProgram.getLightType(), telePositionPairs);
        System.out.println(op);
        op.validateObservingCondition(op);
        o.saveObservingProgram(op);

//        if (op != null) {
//            boolean saved = o.saveObservingProgram(op);
//            if (saved) {
//                System.out.println("SAVE SUCCESS!");
//                return "redirect:/createsuccess";
//            } else {
//                System.out.println("Failed to save ObservingProgram.");
//            }
//        } else {
//            System.out.println("Failed to create ObservingProgram.");
//        }

        return "redirect:/createsuccess";
    }

    @GetMapping("/allObservingPrograms")
    public String showAllObservingPrograms(Model model) {
        OCS ocs = new OCS();
        ArrayList<SciencePlan> sciencePlans = ocs.getAllSciencePlans();


        ObservingProgram[] observingPrograms = new ObservingProgram[sciencePlans.size()];
        int i = 0;
        for (SciencePlan plan: sciencePlans) {
            // observingPrograms[i] = new ObservingProgram(plan);
            System.out.println("plan :");
            System.out.println(plan);
            observingPrograms[i] = new ObservingProgram(i, ocs.getObservingProgramBySciencePlan(plan).getOpticsPrimary(), ocs.getObservingProgramBySciencePlan(plan).getfStop(), ocs.getObservingProgramBySciencePlan(plan).getOpticsSecondaryRMS(),
                    ocs.getObservingProgramBySciencePlan(plan).getScienceFoldMirrorDegree(), ocs.getObservingProgramBySciencePlan(plan).getScienceFoldMirrorType(), ocs.getObservingProgramBySciencePlan(plan).getModuleContent(),
                    ocs.getObservingProgramBySciencePlan(plan).getCalibrationUnit(), ocs.getObservingProgramBySciencePlan(plan).getLightType(), ocs.getObservingProgramBySciencePlan(plan).getTelePositionPair());
            i = i +1;
        }


        model.addAttribute("observingPrograms", observingPrograms);

        return "all_observing_programs";
    }

    @GetMapping("/observing-page")
    public String observingPage(){
        return "observing_page";
    }

    @GetMapping("/createsuccess")
    public String createsuccess(){
        return "createobssuccess";
    }




}

