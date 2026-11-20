package com.joysistvi.recordingstudio;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteSong {

    public static boolean deleteSong(int songId) {

        // Guard Clause / Validation

        if (songId <= 0) {
            System.out.println("Validation Error: Song ID must be greater than 0.");
            return false;
        }

        try {

            Connection conn = DBConnection.getConnection();

            String sql =
                    "DELETE FROM songs WHERE song_id = ?";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, songId);

            int rows = pst.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}