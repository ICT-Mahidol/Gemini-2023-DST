package com.example.demo;

import edu.gemini.app.ocs.model.ObservingProgram;
import edu.gemini.app.ocs.model.TelePositionPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObservingProgramService {

    private final ObservingProgramRepository observingProgramRepository;

    @Autowired
    public ObservingProgramService(ObservingProgramRepository observingProgramRepository) {
        this.observingProgramRepository = observingProgramRepository;
    }

    public void createObservingProgram(ObservingPrograms observingProgram) {
        observingProgramRepository.save(observingProgram);
    }

    public List<ObservingPrograms> getAllObservingPrograms() {
        return observingProgramRepository.findAll();
    }

    public ObservingPrograms validateObservingProgram(ObservingPrograms observingProgram) {
        String opticPriGN = "GNZ";
        String opticPriGS = "GSZ";
        double fStopGNMin = 1.8;
        double fStopGNMax = 8.1;
        double fStopGSMin = 2.9;
        double fStopGSMax = 18.0;
        double opticSecNMin = 5.0;
        double opticSecNMax = 17.0;
        double opticSecSMin = 5.0;
        double opticSecSMax = 13.0;
        double sciFoldDegreeMin = 30.0;
        double sciFoldDegreeMax = 45.0;
        double movDirMin = 0.0;
        double movDirMax = 360.0;
        double movDegMin = 0.0;
        double movDegMax = 70.0;
        boolean validStatus = true;

        String opticPriValue = observingProgram.getOpticsPrimary();
        double fStopValue = observingProgram.getfStop();
        double opticsSecondaryRMS = observingProgram.getOpticsSecondaryRMS();
        double scienceFoldMirrorDegree = observingProgram.getScienceFoldMirrorDegree();
        TelePositionPair[] telePositionPairs = observingProgram.getTelePositionPairs();
        String errorMessage = null;

        if (!opticPriGN.equals(opticPriValue) && !opticPriGS.equals(opticPriValue)) {
            validStatus = false;
            errorMessage = "OpticsPrimary is not correct.";
        } else if (opticPriGN.equals(opticPriValue)) {
            if (fStopValue < fStopGNMin || fStopValue > fStopGNMax) {
                validStatus = false;
                errorMessage = "F-stop out of range.";
            }
        } else if (fStopValue < fStopGSMin || fStopValue > fStopGSMax) {
            validStatus = false;
            errorMessage = "F-stop out of range.";
        }

        if (validStatus) {
            if ("N".equals(observingProgram.getGeminiLocation())) {
                if (opticsSecondaryRMS < opticSecNMin || opticsSecondaryRMS > opticSecNMax) {
                    validStatus = false;
                    errorMessage = "OpticsSecondary(rms surface) out of range.";
                }
            } else {
                if (opticsSecondaryRMS < opticSecSMin || opticsSecondaryRMS > opticSecSMax) {
                    validStatus = false;
                    errorMessage = "OpticsSecondary(rms surface) out of range.";
                }
            }
        }

        if (validStatus) {
            if (scienceFoldMirrorDegree < sciFoldDegreeMin || scienceFoldMirrorDegree > sciFoldDegreeMax) {
                validStatus = false;
                errorMessage = "Science Fold Mirror degree out of range.";
            }
        }

        if (validStatus) {
            for (TelePositionPair tp : telePositionPairs) {
                if (tp.getDirection() < movDirMin || tp.getDirection() > movDirMax) {
                    validStatus = false;
                    errorMessage = "Direction out of range.";
                    break;
                }
                if (tp.getDegree() < movDegMin || tp.getDegree() > movDegMax) {
                    validStatus = false;
                    errorMessage = "Degree out of range.";
                    break;
                }
            }
        }

        // Set validation status and error message
        observingProgram.setValidationStatus(validStatus);
        observingProgram.setErrorMessage(errorMessage);

        return observingProgram;
    }
}