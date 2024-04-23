package th.ac.mahidol.ict.ocs.model;
import edu.gemini.app.ocs.model.SciencePlan.STATUS;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import th.ac.mahidol.ict.ocs.respository.Astronomerrepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

@Entity
@Table(name="scienceplan")
public class SciPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLANNO")
    private int planNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ASTRONOMER_CODE", referencedColumnName = "usercode") // Name of the foreign key column
    private Astronomer astronomer; //


    @Column(name = "CREATOR")
    private String creator;

    @Column(name = "SUBMITTER")
    private String submitter;

    @Column(name = "FUNDINGINUSD")
    private double fundingInUSD;

    @Column(name = "OBJECTIVES")
    private String objectives;

    @Column(name = "STARSYSTEM")
    private String starSystem;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "STARTDATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ENDDATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    @Column(name = "TELESCOPELOCATION")
    private String telescopeLocation;

    @OneToOne
    @JoinColumn(name = "DataRequirement",referencedColumnName = "id")
    private DataRequirement DataRequirements;

    @Column(name = "SPSTATUS")
    private String spStatus;
    public SciPlan() {
        super();
    }

    // Constructor with parameters
    public SciPlan(int planNo,String creator, String submitter, double fundingInUSD, String objectives, String starSystem,
                   Date startDate, Date endDate, String telescopeLocation, DataRequirement dataRequirements, String spStatus) {
        this.planNo = planNo;
        this.creator = creator;
        this.submitter = submitter;
        this.fundingInUSD = fundingInUSD;
        this.objectives = objectives;
        this.starSystem = starSystem;
        this.startDate = startDate;
        this.endDate = endDate;
        this.telescopeLocation = telescopeLocation;
        this.DataRequirements = dataRequirements;
        this.spStatus = spStatus;

    }

    public void setPlanNo(int planNo) {

        this.planNo = planNo;
    }

    public int getPlanNo() {

        return planNo;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public double getFundingInUSD() {
        return fundingInUSD;
    }

    public void setFundingInUSD(double fundingInUSD) {
        this.fundingInUSD = fundingInUSD;
    }

    public String getObjectives() {
        return objectives;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    public String getStarSystem() {
        return starSystem;
    }

    public void setStarSystem(String starSystem) {
        this.starSystem = starSystem;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTelescopeLocation() {
        return telescopeLocation;
    }

    public void setTelescopeLocation(String telescopeLocation) {
        this.telescopeLocation = telescopeLocation;
    }

    public String getSpStatus() {
        return spStatus;
    }

    public void setSpStatus(String spStatus) {
        this.spStatus = String.valueOf(STATUS.valueOf(spStatus));
    }

    public DataRequirement getDataRequirement() {
        return DataRequirements;
    }

    public void setDataRequirement(DataRequirement DataRequirements) {
        this.DataRequirements = DataRequirements;
    }

    public Astronomer getAstronomer() {
        return astronomer;
    }

    public void setAstronomer(Astronomer astronomer) {
        this.astronomer = astronomer;
    }
}
