package com.example.gemini.Model;
import edu.gemini.app.ocs.model.DataProcRequirement;
import edu.gemini.app.ocs.model.SciencePlan;
import edu.gemini.app.ocs.model.StarSystem;
import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//Pattern design == Adapter
@Entity
    @Table(name = "science_plans")
    public class SciencePlanModelGDDG extends SciencePlan {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @Column(name = "id") // กำหนดชื่อ column
        private Integer id;
    @Column(name = "planNo") // กำหนดชื่อ column
    private int planNo;
        @Column(name = "creator") // กำหนดชื่อ column
        private String creator;

        @Column(name = "submitter") // กำหนดชื่อ column
        private String submitter;

        @Column(name = "funding_inusd") // กำหนดชื่อ column
        private Double  fundingInUSD;

        @Column(name = "objectives") // กำหนดชื่อ column
        private String objectives;

        @Enumerated(EnumType.STRING) // กำหนด EnumType เพื่อเก็บค่า Enum ในรูปแบบของ String
        @Column(name = "star_system") // กำหนดชื่อ column
        private StarSystem.CONSTELLATIONS starSystem;

        @Temporal(TemporalType.DATE) // กำหนด TemporalType เป็น DATE เพื่อเก็บเฉพาะวันที่
        @Column(name = "start_date") // กำหนดชื่อ column
        private Date startDate;

        @Temporal(TemporalType.DATE) // กำหนด TemporalType เป็น DATE เพื่อเก็บเฉพาะวันที่
        @Column(name = "end_date") // กำหนดชื่อ column
        private Date endDate;

        @Enumerated(EnumType.STRING) // กำหนด EnumType เพื่อเก็บค่า Enum ในรูปแบบของ String
        @Column(name = "telescope_location") // กำหนดชื่อ column
        private TELESCOPELOC telescopeLocation;

    @Enumerated(EnumType.STRING) // กำหนด EnumType เพื่อเก็บค่า Enum ในรูปแบบของ String
    @Column(name = "status") // กำหนดชื่อ column
    private STATUS status;

    @OneToOne(mappedBy = "sciencePlan", cascade = CascadeType.ALL)
    private DataProcessReqModel dataProcRequirements;
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        public SciencePlanModelGDDG() {

            this.dataProcRequirements = new DataProcessReqModel();
    }
    public SciencePlanModelGDDG(int plan_no ,String creator, String submitter, double fundingInUSD, String objectives, StarSystem.CONSTELLATIONS starSystem, Date startDate, Date endDate, TELESCOPELOC telescopeLocation, DataProcessReqModel dataProcRequirements, int planNo) {
        this.planNo = plan_no;
        this.creator = creator;
        this.submitter = submitter;
        this.fundingInUSD = fundingInUSD;
        this.objectives = objectives;
        this.starSystem = starSystem;
        this.startDate = startDate;
        this.endDate = endDate;
        this.telescopeLocation = telescopeLocation;
        this.dataProcRequirements.add(dataProcRequirements);
    }


    @Override
        public String getCreator() {
            return creator;
        }
    @Override
    public int getPlanNo() {
        return planNo;
    }
    @Override
    public void setPlanNo(int planNo) {
            this.planNo = planNo;

    }
        @Override
        public void setCreator(String creator) {
            this.creator = creator;
        }

        @Override
        public String getSubmitter() {
            return submitter;
        }

        @Override
        public void setSubmitter(String submitter) {
            this.submitter = submitter;
        }

        @Override
        public double getFundingInUSD() {
            return fundingInUSD;
        }

        @Override
        public void setFundingInUSD(double fundingInUSD) {
            this.fundingInUSD = fundingInUSD;
        }

        @Override
        public String getObjectives() {
            return objectives;
        }

        @Override
        public void setObjectives(String objectives) {
            this.objectives = objectives;
        }

        @Override
        public StarSystem.CONSTELLATIONS getStarSystem() {
            return starSystem;
        }

        @Override
        public void setStarSystem(StarSystem.CONSTELLATIONS starSystem) {
            this.starSystem = starSystem;
        }


    @Override
    public String getStartDate() {
        String sDate = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            sDate = formatter.format(this.startDate);
        } catch (Exception var4) {
            sDate = "-1";
        }

        return sDate;
    }
    @Override
    public void setStartDate(String startDate) {
        try {
            this.startDate = formatter.parse(startDate);
        } catch (ParseException var3) {
            var3.printStackTrace();
        }

    }
    @Override
    public String getEndDate() {
        String eDate = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            eDate = formatter.format(this.endDate);
        } catch (Exception var4) {
            eDate = "-1";
        }

        return eDate;
    }
    @Override
    public void setEndDate(String endDate) {
        try {
            this.endDate = formatter.parse(endDate);
        } catch (ParseException var3) {
            var3.printStackTrace();
        }

    }


    @Override
        public TELESCOPELOC getTelescopeLocation() {
            return telescopeLocation;
        }

        @Override
        public void setTelescopeLocation(TELESCOPELOC telescopeLocation) {
            this.telescopeLocation = telescopeLocation;
        }


        @Override
        public SciencePlan.STATUS getStatus() {
            return status;
        }

        @Override
        public void setStatus(SciencePlan.STATUS status) {
            this.status = status;
        }
        @Override
        public void setDataProcRequirements(DataProcRequirement dataProcRequirements) {
            this.dataProcRequirements.add(dataProcRequirements);
        }


    }
