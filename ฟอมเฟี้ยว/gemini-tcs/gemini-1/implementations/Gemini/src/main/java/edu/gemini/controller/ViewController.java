package edu.gemini.controller;

import edu.gemini.app.ocs.model.DataProcRequirement;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewController {

    @GetMapping("/create-science-plan-page")
    public String showCreateSciencePlanPage() {
        return "createSP";
    }

    @GetMapping("/signup")
    public String showSignupPage() {
        return "signup";
    }

    @GetMapping({"/", "/login"})
    public String showLoginPage() {
        return "Login";
    }

    @GetMapping("/home")
    public String showHomePage() {
        return "Home";
    }

    @GetMapping("/alLSPocs")
    public String showSPocs() {
        return "allSP";
    }

    @GetMapping("/view")
    public String showSPDetail() {
        return "viewSP";
    }

}
