package com.example.demo;

import com.example.demo.model.User;
import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.model.ObservingProgram;
import edu.gemini.app.ocs.model.ObservingProgramConfigs;
import edu.gemini.app.ocs.model.SciencePlan;
import edu.gemini.app.ocs.model.TelePositionPair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class DemoController {
    @GetMapping("/")
    public ArrayList<SciencePlan> getAllSciencePlans() {
        OCS o = new OCS();
//        System.out.println(o.getAllSciencePlans());
        return o.getAllSciencePlans();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSciencePlanById(@PathVariable int id) {
        OCS o = new OCS();
        SciencePlan sciencePlan = o.getSciencePlanByNo(id);

        if (sciencePlan == null) {
            // If the science plan with the given ID does not exist, return a 404 Not Found response
            return ResponseEntity.notFound().build();
        } else {
            // If the science plan exists, return it
            return ResponseEntity.ok(sciencePlan);
        }
    }

    @PostMapping("/submitSci/{id}")
    public SciencePlan submitSciencePlan(@PathVariable int id) {
        OCS o = new OCS();
        o.updateSciencePlanStatus(id, SciencePlan.STATUS.TESTED);
        o.submitSciencePlan(o.getSciencePlanByNo(id));
        o.updateSciencePlanStatus(id, SciencePlan.STATUS.SUBMITTED);
        return o.getSciencePlanByNo(id);
    }

    @GetMapping("/observing/{id}")
    public ResponseEntity<?> getObservingProgramById(@PathVariable int id) {
        OCS o = new OCS();
        SciencePlan sciencePlan = o.getSciencePlanByNo(id);

        if (sciencePlan == null) {
            // If the science plan with the given ID does not exist, return a 404 Not Found response
            return ResponseEntity.notFound().build();
        } else {
            // If the science plan exists, retrieve and return the observing program
            ObservingProgram observingProgram = o.getObservingProgramBySciencePlan(sciencePlan);
            return ResponseEntity.ok(observingProgram);
        }
    }


    @PostMapping("/observing")
    public ObservingProgram createObservingProgram(@RequestBody Map<String, Object> body) {

        /*
        List<Map<String, Double>> telePositionPairList = (List<Map<String, Double>>) body.get("telePositionPair");
        TelePositionPair[] t = new TelePositionPair[telePositionPairList.size()];

        int index = 0;
        for (Map<String, Double> telePositionPairObject : telePositionPairList) {
            double direction = telePositionPairObject.get("direction");
            double degree = telePositionPairObject.get("degree");
            TelePositionPair telePositionPair = new TelePositionPair(direction, degree);

            t[index++] = telePositionPair;
        }
        */

        List<Map<String, String>> telePositionPairList = (List<Map<String, String>>) body.get("telePositionPair");
//        System.out.println(telePositionPairList.size());
        TelePositionPair[] t = new TelePositionPair[telePositionPairList.size()];

        int index = 0;
        for (Map<String, String> telePositionPairObject : telePositionPairList) {
            String directionStr = telePositionPairObject.get("direction");
            String degreeStr = telePositionPairObject.get("degree");

            // Parse string values to double
            double direction = Double.parseDouble(directionStr);
            double degree = Double.parseDouble(degreeStr);

            TelePositionPair telePositionPair = new TelePositionPair(direction, degree);
            t[index++] = telePositionPair;

        }
//        System.out.println(Arrays.toString(t));

        OCS o = new OCS();
        ObservingProgram op = o.createObservingProgram(
                o.getSciencePlanByNo(Integer.parseInt(body.get("id").toString())),
                body.get("opticsPrimary").toString(),
                Double.parseDouble(body.get("fStop").toString()),
                Double.parseDouble(body.get("opticsSecondaryRMS").toString()),
                Double.parseDouble(body.get("scienceFoldMirrorDegree").toString()),
                ObservingProgramConfigs.FoldMirrorType.valueOf(body.get("scienceFoldMirrorType").toString()),
                Integer.parseInt(body.get("moduleContent").toString()),
                ObservingProgramConfigs.CalibrationUnit.valueOf(body.get("calibrationUnit").toString()),
                ObservingProgramConfigs.LightType.valueOf(body.get("lightType").toString()),
                t
        );
        op.validateObservingCondition(op);
        o.saveObservingProgram(op);
//        op.setValidationStatus(true);
//        ocs.saveObservingProgram(op);
        ObservingProgram opSc = o.getObservingProgramBySciencePlan(o.getSciencePlanByNo(Integer.parseInt(body.get("id").toString())));
//        System.out.println(opSc);
        return opSc;
    }

    @PostMapping("/validateObserving/{id}")
    public Boolean validateObservingProgram(@PathVariable int id) {
        OCS o = new OCS();
        ObservingProgram opSc = o.getObservingProgramBySciencePlan(o.getSciencePlanByNo(id));
        System.out.println(opSc);
        if (opSc.getValidationStatus() == false){
            opSc.setValidationStatus(true);
            o.saveObservingProgram(opSc);
            return opSc.getValidationStatus();
        } else {
            return opSc.getValidationStatus();
        }
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = GetUsersInDatabase.getUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        List<User> users = GetUsersInDatabase.getUsers();
        for (User u : users) {
            if (u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword())) {
                return ResponseEntity.ok(u.getRole());
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
    }

}
