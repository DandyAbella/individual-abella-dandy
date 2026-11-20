package com.joysistvi.recordingstudio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewArtist {

    public static void viewArtists() {

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM artists";

            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            System.out.println("\n===== ARTIST LIST =====");

            while (rs.next()) {

                System.out.println(
                        "ID: " + rs.getInt("artist_id") +
                                " | Name: " + rs.getString("artist_name") +
                                " | Genre: " + rs.getString("genre") +
                                " | Country: " + rs.getString("country")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}