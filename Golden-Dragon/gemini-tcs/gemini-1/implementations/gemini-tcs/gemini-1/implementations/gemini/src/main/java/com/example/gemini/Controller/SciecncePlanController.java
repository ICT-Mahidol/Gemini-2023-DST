package com.example.gemini.Controller;

import com.example.gemini.Model.*;
import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.model.SciencePlan;
import edu.gemini.app.ocs.model.StarSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class SciecncePlanController {
    OCS ocs = new OCS(true);

    @Autowired
    private SciencePlanRepository sciencePlanRepository;
    @Autowired
    private DataProcReqMentRepository dataProcReqMentRepository;
    @Autowired
    private AstronomerRepository astronomerRepository;

    //  Get all the science plans
    @GetMapping("/testallsp")
    public @ResponseBody Iterable<SciencePlanModelGDDG> testAllSciencePlans() {
        //        model.addAttribute("sciencePlans", sciencePlans);
        return  sciencePlanRepository.findAll();
    }


    @GetMapping("/getAllSP")
    public String getAllSciencePlans(Model model) {
        ArrayList<SciencePlanModelGDDG> sciencePlans = (ArrayList<SciencePlanModelGDDG>) sciencePlanRepository.findAll();
        model.addAttribute("sciencePlans", sciencePlans);
        return "astronomerHomePage";
    }

    @GetMapping("/astronomerCreateSP")
    public String showAstronomerCreateSPPage(  Model model) {
        ArrayList<Astronomer> Astronomers = (ArrayList<Astronomer>) astronomerRepository.findAll();
        model.addAttribute("Astronomers", Astronomers);

        return "astronomerCreateSP"; // ชื่อหน้า HTML ที่ต้องการเชื่อมโยง
    }
    @GetMapping("/astronomerSubmitSP")
    public String showAstronomerSubmitSPPage() {
        return "astronomerSubmitSP"; // ชื่อหน้า HTML ที่ต้องการเชื่อมโยง
    }
    // create science plan

    @PostMapping("/checkId")
    public Object checkSciencePlans(
            @RequestParam("planNo") int planNo,Model model)
    {
        SciencePlanModelGDDG existingSP = sciencePlanRepository.findByplanNo(planNo);
        if (existingSP != null) {
            ModelAndView alertModelAndView = new ModelAndView("astronomerCreateSP");
            alertModelAndView.addObject("alertMessage", "Plan number already exists.");
            ArrayList<Astronomer> Astronomers = (ArrayList<Astronomer>) astronomerRepository.findAll();
            model.addAttribute("Astronomers", Astronomers);

            return alertModelAndView;
//             return "Plan number already exists.";
        }

        ModelAndView alertModelAndView = new ModelAndView("astronomerCreateSP");
        ArrayList<Astronomer> Astronomers = (ArrayList<Astronomer>) astronomerRepository.findAll();
        model.addAttribute("Astronomers", Astronomers);
        alertModelAndView.addObject("alertMessage", "the science plan number does not exist and can be created");
        return alertModelAndView;
    }



    @PostMapping("/createSP")
    public Object createSciencePlans(
            @RequestParam("planNo") int planNo,
            @RequestParam("creator") String creator,
            @RequestParam("submitter") String submitter,
            @RequestParam("fundingInUSD") double fundingInUSD,
            @RequestParam("objectives") String objectives,
            @RequestParam("starSystem") String starSystem,
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate,
            @RequestParam("telescopeLocation") SciencePlan.TELESCOPELOC telescopeLocation,
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

        // Create a new SciencePlanModelGDDG object
        SciencePlanModelGDDG mySP = new SciencePlanModelGDDG() ;
        mySP.setPlanNo(planNo);
        mySP.setCreator(creator);
        mySP.setSubmitter(submitter);
        mySP.setFundingInUSD(fundingInUSD);
        mySP.setObjectives(objectives);
        StarSystem.CONSTELLATIONS constellation = StarSystem.CONSTELLATIONS.valueOf(String.valueOf(starSystem));
        mySP.setStarSystem(constellation);
        mySP.setStartDate(startDate);
        SciencePlan.TELESCOPELOC location = SciencePlan.TELESCOPELOC.valueOf(String.valueOf(telescopeLocation));
        mySP.setTelescopeLocation(location);
        mySP.setEndDate(endDate);
        mySP.setStatus(SciencePlan.STATUS.TESTED);
        DataProcessReqModel dpr1 = new DataProcessReqModel();
        dpr1.setFileType(fileType);
        dpr1.setFileQuality(fileQuality);
        dpr1.setColorType(colorType);
        dpr1.setContrast(contrast);
        dpr1.setBrightness(brightness);
        dpr1.setSaturation(saturation);
        dpr1.setHighlights(highlights);
        dpr1.setExposure(exposure);
        dpr1.setShadows(shadows);
        dpr1.setWhites(whites);
        dpr1.setBlacks(blacks);
        dpr1.setLuminance(luminance);
        dpr1.setHue(hue);
        mySP.setDataProcRequirements(dpr1);
        ocs.createSciencePlan(mySP);
        ocs.updateSciencePlanStatus(mySP.getPlanNo(), SciencePlan.STATUS.TESTED);
        dataProcReqMentRepository.save(dpr1);
        sciencePlanRepository.save(mySP);

        return new ModelAndView("redirect:/getAllSP");
    }


    @PostMapping("/byidSP")
    public ModelAndView getByPlanNo(@RequestParam("planNo") int planNo) {

        SciencePlanModelGDDG mySP  =  sciencePlanRepository.findByplanNo(planNo);

            if (mySP != null ){
                if (mySP.getStatus() == SciencePlan.STATUS.TESTED) {
                   ;
                    ModelAndView modelAndView = new ModelAndView("astronomerSubmitSP");
                    modelAndView.addObject("alertMessage", "This science plan has  been tested already and can be Submitted Science Plan.");
                    modelAndView.addObject("sciencePlansTocontrollerByID", mySP);
                    return modelAndView;
                } else {
                       ModelAndView modelAndView = new ModelAndView("astronomerSubmitSP");
                    modelAndView.addObject("alertMessage", "This science plan has not been tested yet and can't be Submitted Science Plan..");
                    modelAndView.addObject("sciencePlansTocontrollerByID", mySP);
                    return modelAndView;
                }

            }
        else {
            // Create alert message for non-tested science plans
            ModelAndView modelAndView = new ModelAndView("astronomerSubmitSP");
            modelAndView.addObject("alertMessage", "This science plan does not exist.");
            return modelAndView;
        }
    }

    @PostMapping("/submitSP")
    public ModelAndView submitSciencePlans(
            @RequestParam("planNo") int planNo) {
        SciencePlanModelGDDG mySP  =  sciencePlanRepository.findByplanNo(planNo);
       if (mySP.getStatus() == SciencePlan.STATUS.TESTED) {
         ocs.submitSciencePlan(mySP);
           mySP.setStatus(SciencePlanModelGDDG.STATUS.SUBMITTED);
       ModelAndView modelAndView = new ModelAndView("astronomerSubmitSP");
          modelAndView.addObject("submitSPByID",mySP);
           modelAndView.addObject("alertMessage", "SuccessFully.");
       return modelAndView;
        } else {
            // Create alert message for non-tested science plans
            ModelAndView modelAndView = new ModelAndView("astronomerSubmitSP");
            modelAndView.addObject("alertMessage", "This science plan has not been tested yet.");
            return modelAndView;
        }
    }


}


