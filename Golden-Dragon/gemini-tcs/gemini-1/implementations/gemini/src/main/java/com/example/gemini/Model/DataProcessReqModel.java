package com.example.gemini.Model;
import jakarta.persistence.*;
import edu.gemini.app.ocs.model.DataProcRequirement;


    @Entity
    @Table(name = "data_proc_requirements")
    public class DataProcessReqModel extends  DataProcRequirement{

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @Column(name = "id")
        private Long id;

        // Attributes of DataProcRequirement

        private String fileType;
        private String fileQuality;
        private String colorType;
        private double contrast;
        private double brightness;
        private double saturation;
        private double highlights;
        private double exposure;
        private double shadows;
        private double whites;
        private double blacks;
        private double luminance;
        private double hue;
        // One-to-one relationship with SciencePlanModelGDDG
        @OneToOne
        @JoinColumn(name = "science_plan_id")
        private SciencePlanModelGDDG sciencePlan;


    @Override
    public double getHue() {
        return super.getHue();
    }

    @Override
    public void setHue(double hue) {
        super.setHue(hue);
    }

    @Override
    public double getLuminance() {
        return super.getLuminance();
    }

    @Override
    public void setLuminance(double luminance) {
        super.setLuminance(luminance);
    }

    @Override
    public double getBlacks() {
        return super.getBlacks();
    }

    @Override
    public void setBlacks(double blacks) {
        super.setBlacks(blacks);
    }

    @Override
    public double getWhites() {
        return super.getWhites();
    }

    @Override
    public void setWhites(double whites) {
        super.setWhites(whites);
    }

    @Override
    public double getShadows() {
        return super.getShadows();
    }

    @Override
    public void setShadows(double shadows) {
        super.setShadows(shadows);
    }

    @Override
    public double getHighlights() {
        return super.getHighlights();
    }

    @Override
    public void setHighlights(double highlights) {
        super.setHighlights(highlights);
    }

    public DataProcessReqModel() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public double getExposure() {
        return super.getExposure();
    }

    @Override
    public void setExposure(double exposure) {
        super.setExposure(exposure);
    }

    public DataProcessReqModel(String fileType, String fileQuality, String colorType, double contrast, double brightness, double saturation, double highlights, double exposure, double shadows, double whites, double blacks, double luminance, double hue) {
        super(fileType, fileQuality, colorType, contrast, brightness, saturation, highlights, exposure, shadows, whites, blacks, luminance, hue);
    }

    @Override
    public String getFileType() {
        return super.getFileType();
    }

    @Override
    public void setFileType(String fileType) {
        super.setFileType(fileType);
    }

    @Override
    public String getFileQuality() {
        return super.getFileQuality();
    }

    @Override
    public void setFileQuality(String fileQuality) {
        super.setFileQuality(fileQuality);
    }

    @Override
    public String getColorType() {
        return super.getColorType();
    }

    @Override
    public void setColorType(String colorType) {
        super.setColorType(colorType);
    }

    @Override
    public double getContrast() {
        return super.getContrast();
    }

    @Override
    public void setContrast(double contrast) {
        super.setContrast(contrast);
    }

    @Override
    public double getBrightness() {
        return super.getBrightness();
    }

    @Override
    public void setBrightness(double brightness) {
        super.setBrightness(brightness);
    }

    @Override
    public double getSaturation() {
        return super.getSaturation();
    }

    @Override
    public void setSaturation(double saturation) {
        super.setSaturation(saturation);
    }

        public void add(DataProcRequirement dataProcRequirements) {
        }
    }
