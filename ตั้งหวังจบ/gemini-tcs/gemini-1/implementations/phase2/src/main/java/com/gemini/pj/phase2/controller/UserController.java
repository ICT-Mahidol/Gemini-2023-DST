package com.gemini.pj.phase2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.gemini.pj.phase2.repository.UserRepository;
import com.gemini.pj.phase2.model.*;

import java.util.Map;
@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @CrossOrigin
    @GetMapping("/")
    public String login(){
        return "login"  ;
    }

    @CrossOrigin
    @GetMapping("/register")
    public String register(){
        return "register"  ;
    }

    @CrossOrigin
    @GetMapping("/astronomer")
    public String astronomer(){
        return "astronomer"  ;
    }


    @CrossOrigin
    @GetMapping("/create_scienceplan")
    public String create_scienceplan(){
        return "createscienceplan"  ;
    }

    @CrossOrigin
    @GetMapping("/users")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/usersname")
    public @ResponseBody String getUser(@RequestParam(value = "id") int id){
        User user = (User) userRepository.findById(id).get();
        return user.getUserAccountName();
    }

    @CrossOrigin
    @GetMapping("/getperms")
    public @ResponseBody Integer getUserPermission(@RequestParam(value = "id") int id){
        User user = (User) userRepository.findById(id).get();
        System.out.println(user.getUserPermission());
        if(user.getUserPermission().equals("Astronomer")) return 1;
        return 2;
    }

@CrossOrigin
    @PostMapping("/adduser")
    public  @ResponseBody int addUser(@RequestBody Map<String, Object> body) {
        System.out.println(body);
        User newuser = createUser(body);

        for(User user: userRepository.findAll()) {
            if(user.userUsername.equals(newuser.userUsername)) return 0;
        }
        userRepository.save(newuser);

        return 1;
    }

    @CrossOrigin
    @PostMapping("login")
    public @ResponseBody
    int login(@RequestParam(value = "username") String username,
              @RequestParam(value = "password") String password) {
        System.out.println(username + password);
        for(User u: userRepository.findAll()) {
            if(u.userUsername.equals(username)) {
                return u.login(username, password);
            }
        }
        return 0;
    }
    public User createUser(Map<String, Object> body) {
        int id = (int) (userRepository.count() + 1);
        String userUsername = body.get("userUsername").toString();
        String userPassword = body.get("userPassword").toString();
        String userAccountname = body.get("userAccountName").toString();
        String userPermission = body.get("userPermission").toString();

        if(body.get("userPermission").toString().equals("Astronomer")) {
            return new Astronomer(id, userUsername, userPassword, userPermission, userAccountname);
        } else {
            return new Observer(id, userUsername, userPassword, userPermission, userAccountname);
        }
    }
}
