package com.gemini.pj.phase2.model;

import edu.gemini.app.ocs.model.*;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Map;

@Entity
@Table(name = "Astronomer")
public class Astronomer extends User {

    public Astronomer() { }
    public Astronomer(int userId, String userUsername, String userPassword, String userPermission, String userAccountName) {
        super(userId, userUsername, userPassword, userPermission, userAccountName);
    }
    public SciencePlan createSciencePlan(Map<String, Object> body){
        System.out.println("\nCreate a new Science Plan");
		SciencePlan mySP = new SciencePlan();

		mySP.setCreator(this.getUserAccountName());
		mySP.setSubmitter(body.get("submitter").toString());
		mySP.setFundingInUSD(Double.parseDouble(body.get("funding").toString()));
		mySP.setObjectives(body.get("objective").toString());
		mySP.setStarSystem(StarSystem.CONSTELLATIONS.valueOf(body.get("starSystem").toString()));
		mySP.setTelescopeLocation(SciencePlan.TELESCOPELOC.valueOf(body.get("telescopeLocation").toString()));

		mySP.setStartDate(body.get("startdate").toString());
		mySP.setEndDate(body.get("enddate").toString());

		DataProcRequirement dpr1 =
				new DataProcRequirement(body.get("fileType").toString(), body.get("fileQuality").toString(), body.get("colorType").toString(),
						Integer.parseInt(body.get("contrast").toString()), Integer.parseInt(body.get("brightness").toString()), Integer.parseInt(body.get("saturation").toString()), Integer.parseInt(body.get("highlight").toString()), Integer.parseInt(body.get("exposure").toString()), Integer.parseInt(body.get("shadow").toString()),
						Integer.parseInt(body.get("whites").toString()), Integer.parseInt(body.get("blacks").toString()), Integer.parseInt(body.get("luminance").toString()), Integer.parseInt(body.get("hue").toString()));

		mySP.setDataProcRequirements(dpr1);

		ocs.createSciencePlan(mySP);

		return mySP;
    }

	public ArrayList<StarSystem.CONSTELLATIONS> getAllStarSystem() {
		ArrayList<StarSystem.CONSTELLATIONS> allStarSystems = new ArrayList<>();
		for (StarSystem.CONSTELLATIONS constellation : StarSystem.CONSTELLATIONS.values()) {
			allStarSystems.add(constellation);
		}
		return allStarSystems;
	}
	public ArrayList<SciencePlan.TELESCOPELOC> getAllTelescopeLoc() {
		ArrayList<SciencePlan.TELESCOPELOC> allTelescopeLoc = new ArrayList<>();
		for (SciencePlan.TELESCOPELOC tel : SciencePlan.TELESCOPELOC.values()) {
			allTelescopeLoc.add(tel);
		}
		return allTelescopeLoc;
	}

	public String testSciencePlan(SciencePlan sp){
		return ocs.testSciencePlan(sp);
	}

}
