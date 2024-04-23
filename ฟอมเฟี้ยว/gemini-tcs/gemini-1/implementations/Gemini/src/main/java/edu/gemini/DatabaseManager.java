package edu.gemini;

import edu.gemini.app.ocs.model.DataProcRequirement;
import edu.gemini.app.ocs.model.SciencePlan;
import edu.gemini.app.ocs.model.StarSystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
        private static final String URL = "jdbc:mysql://localhost:3306/science_plan_db";
        private static final String USERNAME = "root";
        private static final String PASSWORD = "";

    public static void saveSciencePlan(SciencePlan sciencePlan, DataProcRequirement dpr) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String insertSciencePlanSQL = "INSERT INTO science_plan_db.scienceplan (PlanNo, creator, submitter, funding, objectives, starSystem, startDate, endDate, telescopeLocation, status, fileType, fileQuality, colorType, contrast, brightness, saturation, highlights, exposure, shadows, whites, blacks, luminance, hue) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement sciencePlanStatement = connection.prepareStatement(insertSciencePlanSQL)) {
                sciencePlanStatement.setInt(1, sciencePlan.getPlanNo());
                sciencePlanStatement.setString(2, sciencePlan.getCreator());
                sciencePlanStatement.setString(3, sciencePlan.getSubmitter());
                sciencePlanStatement.setDouble(4, sciencePlan.getFundingInUSD());
                sciencePlanStatement.setString(5, sciencePlan.getObjectives());
                sciencePlanStatement.setString(6, String.valueOf(sciencePlan.getStarSystem()));
                sciencePlanStatement.setString(7, sciencePlan.getStartDate());
                sciencePlanStatement.setString(8, sciencePlan.getEndDate());
                sciencePlanStatement.setString(9, String.valueOf(sciencePlan.getTelescopeLocation()));
                sciencePlanStatement.setString(10, String.valueOf(sciencePlan.getStatus()));
                sciencePlanStatement.setString(11, dpr.getFileType());
                sciencePlanStatement.setString(12, dpr.getFileQuality());
                sciencePlanStatement.setString(13, dpr.getColorType());
                sciencePlanStatement.setDouble(14, dpr.getContrast());
                sciencePlanStatement.setDouble(15, dpr.getBrightness());
                sciencePlanStatement.setDouble(16, dpr.getSaturation());
                sciencePlanStatement.setDouble(17, dpr.getHighlights());
                sciencePlanStatement.setDouble(18, dpr.getExposure());
                sciencePlanStatement.setDouble(19, dpr.getShadows());
                sciencePlanStatement.setDouble(20, dpr.getWhites());
                sciencePlanStatement.setDouble(21, dpr.getBlacks());
                sciencePlanStatement.setDouble(22, dpr.getLuminance());
                sciencePlanStatement.setDouble(23, dpr.getHue());
                sciencePlanStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<SciencePlan> getAllSciencePlans() {
        List<SciencePlan> sciencePlans = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            // Adjust the SQL to format the dates directly in the query
            String sql = "SELECT planNo, creator, submitter, funding, objectives, starSystem, " +
                    "DATE_FORMAT(startDate, '%d/%m/%Y %H:%i:%s') as formattedStartDate, " +
                    "DATE_FORMAT(endDate, '%d/%m/%Y %H:%i:%s') as formattedEndDate, " +
                    "telescopeLocation, status FROM science_plan_db.scienceplan";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                SciencePlan sciencePlan = new SciencePlan();
                sciencePlan.setPlanNo(resultSet.getInt("planNo"));
                sciencePlan.setCreator(resultSet.getString("creator"));
                sciencePlan.setSubmitter(resultSet.getString("submitter"));
                sciencePlan.setFundingInUSD(resultSet.getDouble("funding"));
                sciencePlan.setObjectives(resultSet.getString("objectives"));
                sciencePlan.setStarSystem(StarSystem.CONSTELLATIONS.valueOf(resultSet.getString("starSystem")));
                // Use the formatted date strings from the query
                sciencePlan.setStartDate(resultSet.getString("formattedStartDate"));
                sciencePlan.setEndDate(resultSet.getString("formattedEndDate"));
                sciencePlan.setTelescopeLocation(SciencePlan.TELESCOPELOC.valueOf(resultSet.getString("telescopeLocation")));
                sciencePlan.setStatus(SciencePlan.STATUS.valueOf(resultSet.getString("status")));
                sciencePlans.add(sciencePlan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sciencePlans;
    }
    public static SciencePlan getSciencePlanByPlanNo(int planNo) {
        SciencePlan sciencePlan = null;
        DataProcRequirement dpr = null;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "SELECT *," +
                    "DATE_FORMAT(startDate, '%d/%m/%Y %H:%i:%s') as formattedStartDate, " +
                    "DATE_FORMAT(endDate, '%d/%m/%Y %H:%i:%s') as formattedEndDate " +
                    "FROM science_plan_db.scienceplan WHERE planNo = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, planNo);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                sciencePlan = new SciencePlan();
                sciencePlan.setPlanNo(resultSet.getInt("planNo"));
                sciencePlan.setCreator(resultSet.getString("creator"));
                sciencePlan.setSubmitter(resultSet.getString("submitter"));
                sciencePlan.setFundingInUSD(resultSet.getDouble("funding"));
                sciencePlan.setObjectives(resultSet.getString("objectives"));
                String starSystem = resultSet.getString("starSystem");
                if (starSystem != null) {
                    sciencePlan.setStarSystem(StarSystem.CONSTELLATIONS.valueOf(starSystem));
                } else {
                    // Handle null or log a warning/error
                    System.out.println("Warning: Star system is null for plan no: " + planNo);
                }
                sciencePlan.setStartDate(resultSet.getString("formattedStartDate"));
                sciencePlan.setEndDate(resultSet.getString("formattedEndDate"));
                sciencePlan.setTelescopeLocation(SciencePlan.TELESCOPELOC.valueOf(resultSet.getString("telescopeLocation")));
                sciencePlan.setStatus(SciencePlan.STATUS.valueOf(resultSet.getString("status")));

                dpr = new DataProcRequirement();
                dpr.setFileType(resultSet.getString("fileType"));
                dpr.setFileQuality(resultSet.getString("fileQuality"));
                dpr.setColorType(resultSet.getString("colorType"));
                dpr.setContrast(resultSet.getDouble("contrast"));
                dpr.setBrightness(resultSet.getDouble("brightness"));
                dpr.setSaturation(resultSet.getDouble("saturation"));
                dpr.setHighlights(resultSet.getDouble("highlights"));
                dpr.setExposure(resultSet.getDouble("exposure"));
                dpr.setShadows(resultSet.getDouble("shadows"));
                dpr.setWhites(resultSet.getDouble("whites"));
                dpr.setBlacks(resultSet.getDouble("blacks"));
                dpr.setLuminance(resultSet.getDouble("luminance"));
                dpr.setHue(resultSet.getDouble("hue"));
                sciencePlan.setDataProcRequirements(dpr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sciencePlan;
    }



    public static void deleteSciencePlanById(int planNo) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "DELETE FROM science_plan_db.scienceplan WHERE planNo = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, planNo);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public static void updateSciencePlanStatus(int planNo, SciencePlan.STATUS status) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "UPDATE science_plan_db.scienceplan SET status = ? WHERE planNo = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, status.toString());
                statement.setInt(2, planNo);
                statement.executeUpdate();
                System.out.println("Updated status of Science Plan with Plan No: " + planNo + " to " + status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<SciencePlan> getSciencePlansStatusTest() {
        List<SciencePlan> sciencePlans = new ArrayList<>();
        DataProcRequirement dpr = null;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "SELECT planNo, creator, submitter, funding, objectives, starSystem, " +
                    "DATE_FORMAT(startDate, '%d/%m/%Y %H:%i:%s') as formattedStartDate, " +
                    "DATE_FORMAT(endDate, '%d/%m/%Y %H:%i:%s') as formattedEndDate, " +
                    "telescopeLocation, status, fileType, fileQuality, colorType, contrast, brightness, saturation, " +
                    "highlights, exposure, shadows, whites, blacks, luminance, hue " +
                    "FROM science_plan_db.scienceplan WHERE status = 'TESTED'";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                SciencePlan sciencePlan = new SciencePlan();
                sciencePlan.setPlanNo(resultSet.getInt("planNo"));
                sciencePlan.setCreator(resultSet.getString("creator"));
                sciencePlan.setSubmitter(resultSet.getString("submitter"));
                sciencePlan.setFundingInUSD(resultSet.getDouble("funding"));
                sciencePlan.setObjectives(resultSet.getString("objectives"));
                String starSystem = resultSet.getString("starSystem");
                if (starSystem != null) {
                    sciencePlan.setStarSystem(StarSystem.CONSTELLATIONS.valueOf(starSystem));
                } else {
                    System.out.println("Warning: Star system is null for plan no: " + resultSet.getInt("planNo"));
                }
                sciencePlan.setStartDate(resultSet.getString("formattedStartDate"));
                sciencePlan.setEndDate(resultSet.getString("formattedEndDate"));
                sciencePlan.setTelescopeLocation(SciencePlan.TELESCOPELOC.valueOf(resultSet.getString("telescopeLocation")));
                sciencePlan.setStatus(SciencePlan.STATUS.valueOf(resultSet.getString("status")));

                dpr = new DataProcRequirement();
                dpr.setFileType(resultSet.getString("fileType"));
                dpr.setFileQuality(resultSet.getString("fileQuality"));
                dpr.setColorType(resultSet.getString("colorType"));
                dpr.setContrast(resultSet.getDouble("contrast"));
                dpr.setBrightness(resultSet.getDouble("brightness"));
                dpr.setSaturation(resultSet.getDouble("saturation"));
                dpr.setHighlights(resultSet.getDouble("highlights"));
                dpr.setExposure(resultSet.getDouble("exposure"));
                dpr.setShadows(resultSet.getDouble("shadows"));
                dpr.setWhites(resultSet.getDouble("whites"));
                dpr.setBlacks(resultSet.getDouble("blacks"));
                dpr.setLuminance(resultSet.getDouble("luminance"));
                dpr.setHue(resultSet.getDouble("hue"));
                sciencePlan.setDataProcRequirements(dpr);

                sciencePlans.add(sciencePlan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sciencePlans;
    }
    public static List<SciencePlan> getSciencePlansStatusSaved() {
        List<SciencePlan> sciencePlans = new ArrayList<>();
        DataProcRequirement dpr = null;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "SELECT planNo, creator, submitter, funding, objectives, starSystem, " +
                    "DATE_FORMAT(startDate, '%d/%m/%Y %H:%i:%s') as formattedStartDate, " +
                    "DATE_FORMAT(endDate, '%d/%m/%Y %H:%i:%s') as formattedEndDate, " +
                    "telescopeLocation, status, fileType, fileQuality, colorType, contrast, brightness, saturation, " +
                    "highlights, exposure, shadows, whites, blacks, luminance, hue " +
                    "FROM science_plan_db.scienceplan WHERE status = 'SAVED'";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                SciencePlan sciencePlan = new SciencePlan();
                sciencePlan.setPlanNo(resultSet.getInt("planNo"));
                sciencePlan.setCreator(resultSet.getString("creator"));
                sciencePlan.setSubmitter(resultSet.getString("submitter"));
                sciencePlan.setFundingInUSD(resultSet.getDouble("funding"));
                sciencePlan.setObjectives(resultSet.getString("objectives"));
                String starSystem = resultSet.getString("starSystem");
                if (starSystem != null) {
                    sciencePlan.setStarSystem(StarSystem.CONSTELLATIONS.valueOf(starSystem));
                } else {
                    System.out.println("Warning: Star system is null for plan no: " + resultSet.getInt("planNo"));
                }
                sciencePlan.setStartDate(resultSet.getString("formattedStartDate"));
                sciencePlan.setEndDate(resultSet.getString("formattedEndDate"));
                sciencePlan.setTelescopeLocation(SciencePlan.TELESCOPELOC.valueOf(resultSet.getString("telescopeLocation")));
                sciencePlan.setStatus(SciencePlan.STATUS.valueOf(resultSet.getString("status")));

                dpr = new DataProcRequirement();
                dpr.setFileType(resultSet.getString("fileType"));
                dpr.setFileQuality(resultSet.getString("fileQuality"));
                dpr.setColorType(resultSet.getString("colorType"));
                dpr.setContrast(resultSet.getDouble("contrast"));
                dpr.setBrightness(resultSet.getDouble("brightness"));
                dpr.setSaturation(resultSet.getDouble("saturation"));
                dpr.setHighlights(resultSet.getDouble("highlights"));
                dpr.setExposure(resultSet.getDouble("exposure"));
                dpr.setShadows(resultSet.getDouble("shadows"));
                dpr.setWhites(resultSet.getDouble("whites"));
                dpr.setBlacks(resultSet.getDouble("blacks"));
                dpr.setLuminance(resultSet.getDouble("luminance"));
                dpr.setHue(resultSet.getDouble("hue"));
                sciencePlan.setDataProcRequirements(dpr);

                sciencePlans.add(sciencePlan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sciencePlans;
    }





}



