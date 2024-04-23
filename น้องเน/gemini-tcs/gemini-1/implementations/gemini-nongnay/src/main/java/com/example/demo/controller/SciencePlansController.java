package com.example.demo.controller;

import com.example.demo.model.SciencePlan;
import com.example.demo.repository.SciencePlanRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Controller
public class SciencePlansController {

    @Autowired
    private SciencePlanRepository sciencePlanRepository; // Inject the SciencePlan repository

    @GetMapping("/science-plans")
    public String getAllSciencePlans(Model model) {
        List<SciencePlan> sciencePlans = sciencePlanRepository.findAll(); // Fetch all plans using the repository
        model.addAttribute("sciencePlans", sciencePlans);
        return "science-plans";
    }

    @PostMapping("/approve-science-plan/{planNo}")
    public String approveSciencePlan(@PathVariable int planNo, Model model) {
        Optional<SciencePlan> sciencePlanOptional = sciencePlanRepository.findById(planNo);
        if (sciencePlanOptional.isPresent()) {
            SciencePlan sciencePlan = sciencePlanOptional.get();
            sciencePlan.setStatus("VALIDATED");
            sciencePlanRepository.save(sciencePlan);
            return "redirect:/create-observing-program?planNo=" + planNo;
        } else {
            model.addAttribute("error", "Science Plan not found.");
            return "error";
        }
    }

    @PostMapping("/reject-science-plan/{planNo}")
    public String rejectSciencePlan(@PathVariable int planNo, Model model) {
        Optional<SciencePlan> sciencePlanOptional = sciencePlanRepository.findById(planNo);
        if (sciencePlanOptional.isPresent()) {
            SciencePlan sciencePlan = sciencePlanOptional.get();
            sciencePlan.setStatus("CANCELLED");
            sciencePlanRepository.save(sciencePlan);
            sciencePlanRepository.deleteById(planNo);
            return "redirect:/science-plans"; // Redirect to the list of plans
        } else {
            model.addAttribute("error", "Science Plan not found.");
            return "error"; // Redirect to an error page if plan not found
        }
    }
}
