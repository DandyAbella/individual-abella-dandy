package com.joysistvi.recordingstudio;

import com.joysistvi.recordingstudio.config.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterUser {

    public static boolean registerUser(
            String full_name,
            String user_name,
            String user_password) {

        // Guard Clauses / Validation

        if (full_name == null || full_name.trim().isEmpty()) {
            System.out.println("Validation Error: Full name is required.");
            return false;
        }

        if (user_name == null || user_name.trim().isEmpty()) {
            System.out.println("Validation Error: Username is required.");
            return false;
        }

        if (user_password == null || user_password.length() < 6) {
            System.out.println("Validation Error: Password must be at least 6 characters.");
            return false;
        }

        try {

            Connection conn = DBConnection.getConnection();

            String sql =
                    "INSERT INTO users(full_name, user_name, user_password) " +
                            "VALUES (?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, full_name);
            pst.setString(2, user_name);
            pst.setString(3, user_password);

            int rowsAffected = pst.executeUpdate();

            return rowsAffected > 0;

        } catch (Exception e) {

            System.out.println(e.getMessage());
            return false;
        }
    }
}