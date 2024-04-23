package com.example.demo;

import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.model.SciencePlan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
//        OCS ocs = new OCS();
//        ArrayList<SciencePlan> sciencePlans = ocs.getAllSciencePlans();
//        for (SciencePlan sp : sciencePlans) {
//            System.out.println(sp);
//        }
    }

}
