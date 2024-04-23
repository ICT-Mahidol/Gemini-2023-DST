package com.example.demo;

import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.model.SciencePlan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;


import java.util.Map;

@Controller
class login  {
    @PostMapping("/login")
    public String showLoginPage(@RequestBody String loginForm) {
        String[] params = loginForm.split("&");
        Map<String, String> paramMap = new HashMap<>();
        for (String param : params) {
            String[] keyValue = param.split("=");
            if (keyValue.length == 2) {
                paramMap.put(keyValue[0], keyValue[1]);
            }
        }
        String uname = paramMap.get("uname");
        String psw = paramMap.get("psw");
        if(Objects.equals(uname, "Astronomer") && Objects.equals(psw, "123")){
            return ("redirect:/list-spAstro");
        }
        else if(Objects.equals(uname, "ScienceObserver") && Objects.equals(psw, "123")){
            return ("redirect:/list-spOb");
        }
//        else if(Objects.equals(uname, "ScienceObserver") && Objects.equals(psw, "456")){
//            return "listscienceobserver";
//        }
        return "error";

    }

}

