package com.example.demo.service;

import org.springframework.stereotype.Service;
import edu.gemini.app.ocs.model.ObservingProgramConfigs;
import edu.gemini.app.ocs.model.TelePositionPair;
import edu.gemini.app.ocs.model.ObservingProgram;

@Service
public class ObservingProgramService {

    public ObservingProgram convertToOcsModel(com.example.demo.model.ObservingProgram demoModel) {
        ObservingProgram ocsModel = new ObservingProgram();
        ocsModel.setPlanNo(demoModel.getId());
        ocsModel.setOpticsPrimary(demoModel.getOpticsPrimary());
        ocsModel.setfStop(demoModel.getfStop());
        ocsModel.setOpticsSecondaryRMS(demoModel.getOpticsSecondaryRMS());
        ocsModel.setScienceFoldMirrorDegree(demoModel.getScienceFoldMirrorDegree());
        ocsModel.setCalibrationUnit(ObservingProgramConfigs.CalibrationUnit.valueOf(demoModel.getCalibrationUnit()));
        ocsModel.setLightType(ObservingProgramConfigs.LightType.valueOf(demoModel.getLightType()));
        ocsModel.setTelePositionPair(convertStringToTelePositionPairs(demoModel.getTelePositionPairs()));
        return ocsModel;
    }

    public TelePositionPair[] convertStringToTelePositionPairs(String telePositionPairsString) {
        String[] pairs = telePositionPairsString.split(",");
        TelePositionPair[] telePositionPairs = new TelePositionPair[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            String[] parts = pairs[i].split("-");
            // Parse direction and degree assuming they are properly formatted as doubles
            double direction = Double.parseDouble(parts[0]);
            double degree = Double.parseDouble(parts[1]);
            // Create a new TelePositionPair object with the parsed direction and degree
            telePositionPairs[i] = new TelePositionPair(direction, degree);
        }
        return telePositionPairs;
    }
}
