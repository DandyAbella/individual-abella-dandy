package com.joysistvi.recordingstudio.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        try {

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/user_db",
                    "root",
                    ""
            );

            //System.out.println("Connected to mySQL >> phpMyAdmin >> user_db");

            return conn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}