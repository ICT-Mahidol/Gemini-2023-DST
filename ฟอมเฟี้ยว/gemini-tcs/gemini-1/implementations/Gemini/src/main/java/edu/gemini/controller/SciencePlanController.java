package edu.gemini.controller;

import edu.gemini.DatabaseManager;
import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.model.DataProcRequirement;
import edu.gemini.app.ocs.model.SciencePlan;
import edu.gemini.app.ocs.model.StarSystem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class SciencePlanController {

    @GetMapping("/allSP")
    public ModelAndView getAllSciencePlans() {
        ModelAndView modelAndView = new ModelAndView("allSP");
        List<SciencePlan> allSciencePlans = DatabaseManager.getAllSciencePlans();
        modelAndView.addObject("sciencePlans", allSciencePlans);
        return modelAndView;
    }
    @GetMapping("/allSPocs")
    public ModelAndView getAllSciencePlansOCS() {
        OCS ocs = new OCS();
        ModelAndView modelAndView = new ModelAndView("allSP");
        List<SciencePlan> allSciencePlans = ocs.getAllSciencePlans();
        modelAndView.addObject("sciencePlans", allSciencePlans);
        return modelAndView;
    }
    @PostMapping(value = "/create-science-plan")
    public String createSciencePlan(
            @RequestParam("planNo") int planNo,
            @RequestParam("creator") String creator,
            @RequestParam("submitter") String submitter,
            @RequestParam("funding") double funding,
            @RequestParam("objectives") String objectives,
            @RequestParam("starSystem") String starSystem,
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate,
            @RequestParam("telescopeLocation") String telescopeLocation,
            @RequestParam("fileType") String fileType,
            @RequestParam("fileQuality") String fileQuality,
            @RequestParam("colorType") String colorType,
            @RequestParam("contrast") double contrast,
            @RequestParam("brightness") double brightness,
            @RequestParam("saturation") double saturation,
            @RequestParam("highlights") double highlights,
            @RequestParam("exposure") double exposure,
            @RequestParam("shadows") double shadows,
            @RequestParam("whites") double whites,
            @RequestParam("blacks") double blacks,
            @RequestParam("luminance") double luminance,
            @RequestParam("hue") double hue
    ) {
        SciencePlan sciencePlan = new SciencePlan();
        sciencePlan.setPlanNo(planNo);
        sciencePlan.setCreator(creator);
        sciencePlan.setSubmitter(submitter);
        sciencePlan.setFundingInUSD(funding);
        sciencePlan.setObjectives(objectives);
        sciencePlan.setStarSystem(StarSystem.CONSTELLATIONS.valueOf(starSystem));
        sciencePlan.setStartDate(startDate);
        sciencePlan.setTelescopeLocation(SciencePlan.TELESCOPELOC.valueOf(telescopeLocation));
        sciencePlan.setEndDate(endDate);
        sciencePlan.setStatus(SciencePlan.STATUS.SAVED);

        DataProcRequirement dpr = new DataProcRequirement();
        dpr.setFileType(fileType);
        dpr.setFileQuality(fileQuality);
        dpr.setColorType(colorType);
        dpr.setContrast(contrast);
        dpr.setBrightness(brightness);
        dpr.setSaturation(saturation);
        dpr.setHighlights(highlights);
        dpr.setExposure(exposure);
        dpr.setShadows(shadows);
        dpr.setWhites(whites);
        dpr.setBlacks(blacks);
        dpr.setLuminance(luminance);
        dpr.setHue(hue);

        DatabaseManager.saveSciencePlan(sciencePlan, dpr);
        return "redirect:/allSP";
    }
    @PostMapping("/delete-science-plan")
    public String deleteSciencePlan(@RequestParam("planNo") int planNo) {
        DatabaseManager.deleteSciencePlanById(planNo);
        return "redirect:/allSP";
    }
    @PostMapping(value = "/test-science-plan")
    public String testSciencePlan(@RequestParam("planNo") int planNo) {
        SciencePlan sciencePlan = DatabaseManager.getSciencePlanByPlanNo(planNo);
        OCS ocs = new OCS();
        String testResult = ocs.testSciencePlan(sciencePlan);
        System.out.println("Test Result for Plan No: " + planNo);
        System.out.println(testResult);
        DatabaseManager.updateSciencePlanStatus(planNo, SciencePlan.STATUS.TESTED);
        return "redirect:/allSP";
    }
    @PostMapping("/validateSciencePlan/approve")
    public String approveSciencePlan(@RequestParam("planNo") int planNo, RedirectAttributes redirectAttributes) {
        DatabaseManager.updateSciencePlanStatus(planNo, SciencePlan.STATUS.VALIDATED);
        redirectAttributes.addFlashAttribute("message", "Science Plan with Plan No: " + planNo + " has been successfully validated.");
        return "redirect:/allSP";
    }
    @PostMapping("/validateSciencePlan/reject")
    public String rejectSciencePlan(@RequestParam("planNo") int planNo, RedirectAttributes redirectAttributes) {
        DatabaseManager.updateSciencePlanStatus(planNo, SciencePlan.STATUS.CANCELLED);
        redirectAttributes.addFlashAttribute("message", "Science Plan with Plan No: " + planNo + " has been cancelled.");
        return "redirect:/allSP";
    }

    @GetMapping("/allSP/{planNo}")
    public ModelAndView getSciencePlanDetail(@PathVariable int planNo) {
        ModelAndView modelAndView = new ModelAndView("viewSP");
        SciencePlan sciencePlan = DatabaseManager.getSciencePlanByPlanNo(planNo);
        modelAndView.addObject("sciencePlan", sciencePlan);
        return modelAndView;
    }

    @GetMapping("/validate")
    public ModelAndView getSciplanTested() {
        ModelAndView modelAndView = new ModelAndView("validateSci");
        List<SciencePlan> sciencePlans = DatabaseManager.getSciencePlansStatusTest();
        modelAndView.addObject("sciencePlans", sciencePlans);
        return modelAndView;
    }

    @GetMapping("/Testsciplan")
    public ModelAndView getSciplanSaved() {
        ModelAndView modelAndView = new ModelAndView("testsciplan");
        List<SciencePlan> sciencePlans = DatabaseManager.getSciencePlansStatusSaved();
        modelAndView.addObject("sciencePlans", sciencePlans);
        return modelAndView;
    }
}
