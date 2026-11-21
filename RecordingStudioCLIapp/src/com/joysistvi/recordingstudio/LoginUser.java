package com.joysistvi.recordingstudio;

import com.joysistvi.recordingstudio.config.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginUser {

    public static boolean login(String user_name, String user_password) {

        try {

            Connection conn = DBConnection.getConnection();

            System.out.println("INPUT USERNAME = [" + user_name + "]");
            System.out.println("INPUT PASSWORD = [" + user_password + "]");

            String sql = "SELECT * FROM users WHERE user_name = ? AND user_password = ?";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, user_name);
            pst.setString(2, user_password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("MATCH FOUND");
                return true;
            }

            System.out.println("NO MATCH FOUND");
            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
