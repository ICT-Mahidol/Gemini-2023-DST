package com.example.demo;

import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.model.SciencePlan;
import edu.gemini.app.ocs.model.StarSystem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class SciencePlanController {

    // Display the form to create a new Science Plan
//    @GetMapping("/createSciencePlan")
//    public String showSciencePlanForm(Model model) {
//        model.addAttribute("sciencePlan", new SciencePlan());
//        model.addAttribute("starSystems", StarSystem.CONSTELLATIONS.values());
//        model.addAttribute("telescopeLocations", SciencePlan.TELESCOPELOC.values());
//        return "science_plan_form";
//    }
    @GetMapping("/createSciencePlan")
    public String showSciencePlanForm(Model model) {
        // Create a new SciencePlan object and add it to the model
        SciencePlan sciencePlan = new SciencePlan();
        model.addAttribute("sciencePlan", sciencePlan);

        // Add star systems and telescope locations to the model
        model.addAttribute("starSystems", StarSystem.CONSTELLATIONS.values());
        model.addAttribute("telescopeLocations", SciencePlan.TELESCOPELOC.values());

        // Return the name of the Thymeleaf template to render
        return "science_plan_form";
    }

    // Save the new Science Plan
    @PostMapping("/saveSciencePlan")
    public String saveSciencePlan(@ModelAttribute("sciencePlan") SciencePlan sciencePlan,
                                  @RequestParam("startDateStr") String startDateStr,
                                  @RequestParam("endDateStr") String endDateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  // Updated date format here
        try {
            Date startDate = dateFormat.parse(startDateStr);
            Date endDate = dateFormat.parse(endDateStr);
            sciencePlan.setStartDate(startDate);
            sciencePlan.setEndDate(endDate);
        } catch (Exception e) {
            e.printStackTrace();
            return "error"; // Redirect to an error page
        }

        // Sanitize inputs that will be incorporated into SQL queries
        sciencePlan.setCreator(sciencePlan.getCreator().replace("'", "''"));
        sciencePlan.setSubmitter(sciencePlan.getSubmitter().replace("'", "''"));
        sciencePlan.setObjectives(sciencePlan.getObjectives().replace("'", "''"));

        OCS ocs = new OCS();
        String creationResult = ocs.createSciencePlan(sciencePlan);
        System.out.println(creationResult);

        return "redirect:/createSuccess"; // Redirect to a success page
    }

    // List all Science Plans
    @GetMapping("/allSciencePlans")
    public String showAllSciencePlans(Model model) {
        OCS ocs = new OCS();
        model.addAttribute("sciencePlans", ocs.getAllSciencePlans());
        return "all_science_plans";
    }

    // Page shown after successful creation
    @GetMapping("/createSuccess")
    public String createSuccess() {
        return "create_success";
    }

    @GetMapping("/sciplan-page")
    public String sciplanPage() {
        return "sciplan_page";
    }


}
