package com.example.demo;

import com.example.demo.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class GetUsersInDatabase {
    private static final String DB_URL = "jdbc:h2:./ocs";
    private static final String USER = "sa";
    private static final String PASS = "";

    public static List<User> getUsers() {
        List<User> userList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "SELECT * FROM users";
            try (Statement stmt = conn.createStatement()) {
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    while (rs.next()) {
                        String username = rs.getString("username");
                        String password = rs.getString("password");
                        String email = rs.getString("email");
                        String phoneNumber = rs.getString("phone_number");
                        String role = rs.getString("role");

                        User user = new User(username, password, email, phoneNumber, role);
                        userList.add(user);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }
}
