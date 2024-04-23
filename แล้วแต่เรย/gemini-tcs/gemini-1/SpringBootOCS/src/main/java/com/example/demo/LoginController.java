package com.example.demo;//package com.example.demo;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.file.AccessDeniedException;

@Controller
@EnableJpaRepositories(basePackages = "com.example.demo.repositories")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password, HttpSession session, Model model) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user != null) {
            session.setAttribute("loggedInUsername", username); // Set session attribute
            return "redirect:/navigation"; // Redirect to the navigation page
        }
        model.addAttribute("error", "Invalid username or password");
        return "login";
    }

    @GetMapping("/navigation")
    public String navigationPage(HttpServletRequest request, Model model) {
        // Retrieve logged-in user's username from session
        String loggedInUsername = (String) request.getSession().getAttribute("loggedInUsername");
        if (loggedInUsername != null) {
            // Retrieve user from the database based on the username
            User user = userRepository.findByUsername(loggedInUsername);
            if (user != null) {
                // Add user's roles to the model
                model.addAttribute("roles", user.getRoles());
                return "navigation"; // Return the navigation page
            }
        }
        throw new RuntimeException("User not found or not logged in"); // Handle this error appropriately
    }

    @GetMapping("/astronomer")
    public String astronomerPage(HttpServletRequest request) throws AccessDeniedException {
        if (hasRole(request, "astronomer")) {
            // Process astronomer action
            return "sciplan_page"; // Return the astronomer page
        } else {
            throw new AccessDeniedException("Access denied"); // Handle access denied scenario
        }
    }

    @GetMapping("/science-observer")
    public String scienceObserverPage(HttpServletRequest request) throws AccessDeniedException {
        if (hasRole(request, "science observer")) {
            // Process science observer action
            return "observing_page"; // Return the science observer page
        } else {
            throw new AccessDeniedException("Access denied"); // Handle access denied scenario
        }
    }

    @GetMapping("/telescope-operator")
    public String telescopeOperatorPage(HttpServletRequest request) throws AccessDeniedException {
        if (hasRole(request, "telescope operator")) {
            // Process telescope operator action
            return "teleop"; // Return the telescope operator page
        } else {
            throw new AccessDeniedException("Access denied"); // Handle access denied scenario
        }
    }

    // Utility method to check if the user has the specified role
    private boolean hasRole(HttpServletRequest request, String role) {
        String loggedInUsername = (String) request.getSession().getAttribute("loggedInUsername");
        if (loggedInUsername != null) {
            User user = userRepository.findByUsername(loggedInUsername);
            if (user != null) {
                return user.getRoles().contains(role);
            }
        }
        return false;
    }

    @GetMapping("/create-user")
    public String showCreateUserForm() {
        return "create-user";
    }

    @PostMapping("/create-user")
    public String createUser(@RequestParam String username,
                             @RequestParam String password,
                             @RequestParam String roles,
                             Model model) {
        // Create a new user object
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setRoles(roles);

        // Save the user to the database
        userRepository.save(newUser);

        // Redirect to a confirmation page or any other page
        return "redirect:/user-created";
    }

    @GetMapping("/user-created")
    public String showUserCreatedPage() {
        return "user-created";
    }


}

