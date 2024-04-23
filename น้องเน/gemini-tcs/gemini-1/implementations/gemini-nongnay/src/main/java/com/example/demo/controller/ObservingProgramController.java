package com.example.demo.controller;

import com.example.demo.model.ObservingProgram;
import com.example.demo.model.SciencePlan;
import com.example.demo.repository.ObservingProgramRepository;
import com.example.demo.repository.SciencePlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.demo.service.ObservingProgramService;

import java.util.List;

@Controller
public class ObservingProgramController {
    @Autowired
    private SciencePlanRepository sciencePlanRepository;

    @Autowired
    private ObservingProgramRepository observingProgramRepository;

    @Autowired
    private ObservingProgramService observingProgramService;

    @GetMapping("/create-observing-program")
    public String showCreateObservingProgramForm(Model model, @RequestParam("planNo") int planNo) {
        SciencePlan sciencePlan = sciencePlanRepository.findById(planNo).orElse(null);
        if (sciencePlan == null) {
            return "redirect:/error";
        }
        model.addAttribute("sciencePlan", sciencePlan);
        return "create-observing-program";
    }

    @PostMapping("/create-observing-program")
    public String createObservingProgram(@ModelAttribute ObservingProgram observingProgram, RedirectAttributes redirectAttributes) {
        observingProgramRepository.save(observingProgram);
        redirectAttributes.addFlashAttribute("successMessage", "Observing Program created successfully!");
        return "success";
    }

    @GetMapping("/observing-programs")
    public String showObservingPrograms(Model model) {
        List<ObservingProgram> observingPrograms = observingProgramRepository.findAll();
        model.addAttribute("observingPrograms", observingPrograms);
        return "observing-programs";  // Make sure this view exists
    }

    @GetMapping("/approve-observing-program/{id}")
    public String validateAndApproveObservingProgram(@PathVariable int id, RedirectAttributes redirectAttributes) {
        ObservingProgram demoModel = observingProgramRepository.findById(id).orElse(null);
        if (demoModel == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Observing Program not found!");
            return "redirect:/observing-programs";
        }
        edu.gemini.app.ocs.model.ObservingProgram ocsModel = observingProgramService.convertToOcsModel(demoModel);
        // Assuming validateObservingCondition method modifies the object itself and sets validation status
        ocsModel.validateObservingCondition(ocsModel);
        // Assuming you then need to update your original model with the validation status from the OCS model
        demoModel.setValidationStatus(ocsModel.getValidationStatus());
        // Save the updated status back to your repository
        observingProgramRepository.save(demoModel);
        redirectAttributes.addFlashAttribute("successMessage", "Observing Program validated and approved successfully!");
        return "redirect:/observing-programs";
    }

    @GetMapping("/reject-observing-program/{id}")
    public String rejectObservingProgram(@PathVariable int id, RedirectAttributes redirectAttributes) {
        try {
            observingProgramRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("successMessage", "Observing Program rejected and deleted successfully!");
        } catch (Exception e) {
            // Log the exception
            redirectAttributes.addFlashAttribute("errorMessage", "There was a problem rejecting the Observing Program.");
        }
        return "redirect:/observing-programs";
    }
}
