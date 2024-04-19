package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateUserTable {
    private static final String DB_URL = "jdbc:h2:./ocs";
    private static final String USER = "sa";
    private static final String PASS = "";

    public void createTableIfNotExists() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "CREATE TABLE IF NOT EXISTS users (" +
                    "username VARCHAR(255) NOT NULL," +
                    "password VARCHAR(255) NOT NULL," +
                    "email VARCHAR(255) NOT NULL," +
                    "phone_number VARCHAR(20)," +
                    "role VARCHAR(50)" +
                    ")";
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CreateUserTable creator = new CreateUserTable();
        creator.createTableIfNotExists();
    }
}