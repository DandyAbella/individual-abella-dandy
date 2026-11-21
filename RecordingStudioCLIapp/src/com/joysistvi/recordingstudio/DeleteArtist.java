package com.joysistvi.recordingstudio;

import com.joysistvi.recordingstudio.config.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteArtist {

    public static boolean deleteArtist(int artistId) {

        // Guard Clause / Validation

        if (artistId <= 0) {
            System.out.println("Validation Error: Artist ID must be greater than 0.");
            return false;
        }

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "DELETE FROM artists WHERE artist_id = ?";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, artistId);

            int rows = pst.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}