package com.example.demo;

import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.model.SciencePlan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class UserController {
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        return "Login";
    }
}



//    @PostMapping("/login")
//    public String login(@RequestParam String username, @RequestParam String password, Model model) {
//        User user = userRepository.findByUsername(username);
//        if (user != null && user.getPassword().equals(password)) {
//            model.addAttribute("user", user);
//            return "redirect:/dashboard"; // Redirect to the dashboard page
//        } else {
//            model.addAttribute("error", "Invalid username or password");
//            return "login"; // Redirect back to the login page with an error message
//        }
//    }
//
//    @GetMapping("/dashboard")
//    public String showDashboard(Model model) {
//        // Implement logic to show dashboard based on user role or other user-related data
//        return "dashboard"; // Return the name of your dashboard HTML page
//    }
//
//    @GetMapping("/profile/{id}")
//    public String showUserProfile(@PathVariable Long id, Model model) {
//        User user = userRepository.findById(id).orElse(null);
//        if (user == null) {
//            return "redirect:/users/dashboard"; // Redirect to dashboard if user not found
//        }
//        model.addAttribute("user", user);
//        return "profile"; // Return the name of your profile HTML page
//    }
//
//    // Add more methods as needed for user management
//
//    @RequestMapping("/astronomers")
//    public class AstronomerController {
//    }
//    public class ScienceObserverController {
//
//    }




