package com.joysistvi.recordingstudio;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddSong {

    public static boolean addSong(
            String songTitle,
            String duration,
            int albumId) {

        // Guard Clauses / Validation

        if (songTitle == null || songTitle.trim().isEmpty()) {
            System.out.println("Validation Error: Song title is required.");
            return false;
        }

        if (duration == null || duration.trim().isEmpty()) {
            System.out.println("Validation Error: Duration is required.");
            return false;
        }

        if (albumId <= 0) {
            System.out.println("Validation Error: Album ID must be greater than 0.");
            return false;
        }

        try {

            Connection conn = DBConnection.getConnection();

            String sql =
                    "INSERT INTO songs " +
                            "(song_title, duration, album_id) " +
                            "VALUES (?, ?, ?)";

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, songTitle);
            pst.setString(2, duration);
            pst.setInt(3, albumId);

            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}