package th.ac.mahidol.ict.ocs;


import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.model.SciencePlan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.ac.mahidol.ict.ocs.model.*;
import th.ac.mahidol.ict.ocs.respository.*;

import java.lang.reflect.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HengHengOcsController {

    @Autowired
    private ScienceObserverRepository sciRepository;

    @Autowired
    private SciencePlanRepository sciencePlanRepository;
    @Autowired
    private Astronomerrepository Astronomerrepository;
    @Autowired
    private UserRepository userrepository;
    @Autowired
    private ScienceObserverRepository scienceObserverRepository;

    @Autowired
    private dataRequirementRepository dataRequirementRepository;;

    @CrossOrigin
    @GetMapping("/")

    public String home() {// Fetch all SciObserver entities from the repository
        return "Home";

    }

    @GetMapping("/sciobs")
    @ResponseBody
    public Iterable<SciObserver>getallsciobservers() {// Fetch all SciObserver entities from the repository
         return scienceObserverRepository.findAll();

    }
    @GetMapping("/astros")
    @ResponseBody
    public Iterable<Astronomer> getAllAstronomers() {
        // Return all astronomers from the repository
        return Astronomerrepository.findAll();
    }

    @GetMapping("/scips")
    @ResponseBody
    public Iterable<SciPlan> getAllSciplans() {
        // Return all astronomers from the repository
        return sciencePlanRepository.findAll();
    }


    @GetMapping("/login")
    public String ShowloginForm() {
        // Code to prepare the "create sci plan" page
        //return "/login"; // Return the name of the Thymeleaf template file for the "create sci plan" page
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        User authenticatedUser = userrepository.findByUsername(user.getUsername());

        // Check if user exists
        if (authenticatedUser == null) {
            // User not found, add generic error message and return to login page
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }

        // Check if password and email match
        if (!authenticatedUser.getPassword().equals(user.getPassword()) ||
                !authenticatedUser.getEmail().equals(user.getEmail())) {
            // Password or email does not match, add generic error message and return to login page
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }

        // Check if role matches
        if (!authenticatedUser.getRole().equals(user.getRole())) {
            // Role does not match, add generic error message and return to login page
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }

        // Authentication successful, redirect based on user role
        String role = authenticatedUser.getRole();
        if ("Astronomer".equals(role)) {
            // Redirect to astronomer page
            return "redirect:/science-plans";
        } else if ("Science Observer".equals(role)) {
            // Redirect to science observer page
            return "redirect:/science-plans-observer";
        }

        // Invalid role, add generic error message and return to login page
        model.addAttribute("error", "Invalid credentials");
        return "login";
    }


    @GetMapping("/science-plans")
    public String getAllSciencePlans(Model model) {
        model.addAttribute("sciplans", sciencePlanRepository.findAll());
        return "Sciplandata_astronomer"; // This maps to sciPlanList.html in src/main/resources/templates
    }

    @GetMapping("/science-plans-observer")
    public String getAllSciencePlans2(Model model) {
        model.addAttribute("sciplans", sciencePlanRepository.findAll());
        return "Sciplandata_observer";
    }



    @PostMapping("/submit")
    public String submitForm(@RequestParam("astronomerCode") Long astronomerId) {
        // Code to process the selected astronomerId
        // Redirect to the create sci plan page
        return "redirect:/create_plan"; // Redirect to the URL of the create sci plan page
    }

    @GetMapping("/create_plan")
    public String createSciPlanPage(Model model) {
        // Code to prepare the "create sci plan" page
        Iterable<Astronomer> astronomers = Astronomerrepository.findAll();
        model.addAttribute("astronomers",astronomers);
        return "create_plan"; // Return the name of the Thymeleaf template file for the "create sci plan" page
    }

    @PostMapping("/create-plan")
    public String createPlan(@ModelAttribute SciPlan sciPlan,
                             String astronomerCode) {
        // Fetch Astronomer from the repository
        Astronomer astronomer = (Astronomer) Astronomerrepository.findByUsercode(astronomerCode).orElse(null);

        if (astronomer == null) {
            // Handle case when Astronomer with provided ID is not found
            // You may return an error message or handle it based on your application logic
            return "redirect:/create_plan"; // Redirect back to create_plan page with an error message
        }

        DataRequirement dataRequirement = sciPlan.getDataRequirement();

        // Save the dataRequirement to the repository
        dataRequirement = dataRequirementRepository.save(dataRequirement);

        // Set the dataRequirement in the sciPlan object
        sciPlan.setDataRequirement(dataRequirement);
        // Set other fields and save SciPlan
        sciPlan.setAstronomer(astronomer);

        sciPlan.setSpStatus("SAVED");
        sciencePlanRepository.save(sciPlan);

        return "redirect:/science-plans";
    }

    @GetMapping("/testSciPlan")
    public String testSciencePlan(Model model) {
        model.addAttribute("sciplans", sciencePlanRepository.findAll());

        return "testSciPlan";
    }
    @PostMapping("/test")
    public String runTest(@RequestParam("planNo") long planNo, Model model) {
        // Fetch the SciPlan from the repository
        Optional<SciPlan> optionalSciPlan = sciencePlanRepository.findById(planNo);
        if (optionalSciPlan.isPresent()) {
            SciPlan sciPlan = optionalSciPlan.get();

            // Update the status
            sciPlan.setSpStatus("TESTED");

            // Save the updated SciPlan back to the database
            sciencePlanRepository.save(sciPlan);

            String result = "success";
            model.addAttribute("result", result);
        } else {
            String result = "failure";
            model.addAttribute("result", result);
        }

        // Add all SciPlans to the model
        model.addAttribute("sciplans", sciencePlanRepository.findAll());

        return "testSciPlan";
}


    @GetMapping("/validSciPlan")
    public String validateSciencePlan(Model model) {
        model.addAttribute("sciplans", sciencePlanRepository.findAll());

        return "validateSciPlan";
    }

@PostMapping("/validate")
public String validate(@RequestParam("planNo") long planNo,
                       @RequestParam("action") String action,
                       Model model) {
    // Fetch the SciPlan from the repository
    Optional<SciPlan> optionalSciPlan = sciencePlanRepository.findById(planNo);
    if (optionalSciPlan.isPresent()) {
        SciPlan sciPlan = optionalSciPlan.get();

        // Update the status based on the action
        if ("validate".equals(action)) {
            sciPlan.setSpStatus("VALIDATED");
        } else if ("invalidate".equals(action)) {
            sciPlan.setSpStatus("INVALIDATED");
        } else {
            // Handle invalid action
            String result = "failure";
            model.addAttribute("result", result);
            model.addAttribute("sciplans", sciencePlanRepository.findAll());
            return "validateSciPlan";
        }
        sciencePlanRepository.save(sciPlan);

        String result = "success";
        model.addAttribute("result", result);
    } else {
        String result = "failure";
        model.addAttribute("result", result);
    }


    // Add all SciPlans to the model
    model.addAttribute("sciplans", sciencePlanRepository.findAll());

    return "validateSciPlan";
}



    @GetMapping("/checksciplan")
    public String checkSciplanForm(Model model) {
        model.addAttribute("plan", new SciencePlan()); // Assuming SciencePlan is your data model
        return "checksciplan";
    }


    @PostMapping("/checkId")
    @ResponseBody
    public String checkSciplan(@ModelAttribute SciencePlan plan) {
        List<SciPlan> plans = (List<SciPlan>) sciencePlanRepository.findAll();

        boolean exists = false;

        String inputObjectives = plan.getObjectives().trim();

        String[] inputObjectiveArray = inputObjectives.split("\\d+\\.\\s+");

        for (String inputObjective : inputObjectiveArray) {
            inputObjective = inputObjective.trim();

            for (SciPlan existingPlan : plans) {
                String existingObjectives = existingPlan.getObjectives().trim();

                String[] existingObjectiveArray = existingObjectives.split("\\d+\\.\\s+");

                for (String existingObjective : existingObjectiveArray) {
                    existingObjective = existingObjective.trim();

                    if (existingObjective.endsWith(".")) {
                        existingObjective = existingObjective.substring(0, existingObjective.length() - 1);
                    }
                    System.out.println("Existing: " +existingObjective);
                    System.out.println("Input: " + inputObjective);
                    if (existingObjective.contains(inputObjective)) {
                        exists = true;
                        break;
                    }
                }

                if (exists) {
                    break;
                }
            }

            if (exists) {
                break;
            }
        }

        if (exists) {
            return "<div style='background-color: #f44336; color: white; padding: 50px; font-family: Arial, sans-serif; font-size: larger; text-align: center;'>A similar Sciplan already exists in the database!<br><button style='margin-top: 10px; background-color: #ff6600; color: white; border: none; border-radius: 4px; padding: 10px 20px; cursor: pointer;' onclick='window.location.href=\"/checksciplan\";'>Back</button></div>";
        } else {
            return "<div style='background-color: #4CAF50; color: white; padding: 50px; font-family: Arial, sans-serif; font-size: large; text-align: center;'>No similar Sciplan found in the database. You can proceed to create it.<br><button style='margin-top: 10px; padding: 5px 10px; background-color: #ff6600; color: white; border: none; border-radius: 4px; padding:10px 20px; cursor: pointer; type='submit' onclick='window.location.href=\"/create_plan\";'>Create</button></div>";
        }
    }
}