package com.joysistvi.recordingstudio;

import com.joysistvi.recordingstudio.config.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddArtist {

    public static boolean addArtist(
            String artistName,
            String genre,
            String country) {

        // Guard Clauses / Validation
        if (artistName == null || artistName.trim().isEmpty()) {
            System.out.println("Validation Error: Artist name is required.");
            return false;
        }

        if (genre == null || genre.trim().isEmpty()) {
            System.out.println("Validation Error: Genre is required.");
            return false;
        }

        if (country == null || country.trim().isEmpty()) {
            System.out.println("Validation Error: Country is required.");
            return false;
        }

        try {

            Connection conn = DBConnection.getConnection();

            String sql =
                    "INSERT INTO artists " +
                            "(artist_name, genre, country) " +
                            "VALUES (?, ?, ?)";

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, artistName);
            pst.setString(2, genre);
            pst.setString(3, country);

            int rows = pst.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }
}