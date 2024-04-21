package com.example.demo.h2;

import com.example.demo.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUser {
    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:./ocs";
    private static final String USER = "sa";
    private static final String PASS = "";

    public void insertUser(User user) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "INSERT INTO users (username, password, email, phone_number, role) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, user.getUsername());
                pstmt.setString(2, user.getPassword());
                pstmt.setString(3, user.getEmail());
                pstmt.setString(4, user.getPhoneNumber());
                pstmt.setString(5, user.getRole());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        User user = new User("user3","user3", "user3@gmail.com", "0981234567", "ScienceObserver");

        InsertUser inserter = new InsertUser();
        inserter.insertUser(user);
    }
}