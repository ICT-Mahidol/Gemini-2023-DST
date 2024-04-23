package com.example.demo;

import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.model.ObservingProgram;
import edu.gemini.app.ocs.model.ObservingProgramConfigs;
import edu.gemini.app.ocs.model.SciencePlan;
import edu.gemini.app.ocs.model.TelePositionPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DemoController {

    private final ObservingProgramService observingProgramService;

    @Autowired
    public DemoController(ObservingProgramService observingProgramService) {
        this.observingProgramService = observingProgramService;
    }

    @CrossOrigin
    @GetMapping("/list-spOb")
    public String getAllSciencePlansOB(Model model) {
        OCS ocs = new OCS();
        List<SciencePlan> sciencePlans = ocs.getAllSciencePlans();
        model.addAttribute("sciencePlans", sciencePlans);
        return "Science_Plans";
    }

    @GetMapping("/list-spAstro")
    public String getAllSciencePlans(Model model) {
        OCS ocs = new OCS();
        List<SciencePlan> sciencePlans = ocs.getAllSciencePlans();
        model.addAttribute("sciencePlans", sciencePlans);
        return "ListSciencePlanAstro";
    }

    @GetMapping("/NewSP")
    public String showNewSciencePlanPage() {
        return "NewSciencePlan"; // ชื่อของหน้า HTML ที่ต้องการให้แสดง
    }


    @GetMapping("/createObservingProgram/{planNo}")
    public String showCreateObservingProgramForm(@PathVariable("planNo") int planNo, Model model) {
        model.addAttribute("planNo", planNo);
        return "createObservingProgram";
    }

    @GetMapping("/listscienceobserver")
    public String getListScienceObserver(Model model) {
        List<ObservingPrograms> sciencePrograms = observingProgramService.getAllObservingPrograms();
        model.addAttribute("sciencePrograms", sciencePrograms);
        return "listscienceobserver";
    }


    @PostMapping("/create-op")
    public String createObservingProgram(
            @RequestParam int planNo,
            @RequestParam String geminiLocation,
            @RequestParam String opticsPrimary,
            @RequestParam double fStop,
            @RequestParam double opticsSecondaryRMS,
            @RequestParam double scienceFoldMirrorDegree,
            @RequestParam String scienceFoldMirrorType,
            @RequestParam int moduleContent,
            @RequestParam String calibrationUnit,
            @RequestParam String lightType,
            @RequestParam double telePosition1X,
            @RequestParam double telePosition1Y,
            @RequestParam double telePosition2X,
            @RequestParam double telePosition2Y,
            @RequestParam double telePosition3X,
            @RequestParam double telePosition3Y,
            @RequestParam double telePosition4X,
            @RequestParam double telePosition4Y,
            @RequestParam double telePosition5X,
            @RequestParam double telePosition5Y,
            Model model
    ) {
        // Create TelePositionPair array
        TelePositionPair[] telePositionPairs = {
                new TelePositionPair(telePosition1X, telePosition1Y),
                new TelePositionPair(telePosition2X, telePosition2Y),
                new TelePositionPair(telePosition3X, telePosition3Y),
                new TelePositionPair(telePosition4X, telePosition4Y),
                new TelePositionPair(telePosition5X, telePosition5Y)
        };

        // Validate scienceFoldMirrorType
        ObservingProgramConfigs.FoldMirrorType foldMirrorType;
        try {
            foldMirrorType = ObservingProgramConfigs.FoldMirrorType.valueOf(scienceFoldMirrorType.toUpperCase());
        } catch (IllegalArgumentException e) {
            // Handle invalid enum value
            model.addAttribute("error", "Invalid scienceFoldMirrorType");
            return "error";
        }

        // Validate calibrationUnit and lightType
        ObservingProgramConfigs.CalibrationUnit calUnit;
        ObservingProgramConfigs.LightType lType;
        try {
            calUnit = ObservingProgramConfigs.CalibrationUnit.valueOf(calibrationUnit.toUpperCase());
            lType = ObservingProgramConfigs.LightType.valueOf(lightType.toUpperCase());
        } catch (IllegalArgumentException e) {
            // Handle invalid enum value
            model.addAttribute("error", "Invalid calibrationUnit or lightType");
            return "error";
        }


        // Create ObservingProgram object
        ObservingPrograms observingProgram = new ObservingPrograms(
                planNo, opticsPrimary, fStop, opticsSecondaryRMS, scienceFoldMirrorDegree,
                foldMirrorType, moduleContent, calUnit, lType, telePositionPairs
        );

        /// Validate ObservingProgram
        ObservingPrograms validatedOp = observingProgramService.validateObservingProgram(observingProgram);

        if (validatedOp.isValidationStatus()) {
            // Save ObservingProgram to database
            observingProgramService.createObservingProgram(validatedOp);
            // Redirect to list of observing programs
            return "redirect:/listobservingprogram";
        } else {
            // Handle validation failure
            model.addAttribute("error", "Observing program validation failed");
            return "error";

        }
    }
}
