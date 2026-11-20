package com.joysistvi.recordingstudio;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteAlbum {

    public static boolean deleteAlbum(int albumId) {

        // Guard Clause / Validation

        if (albumId <= 0) {
            System.out.println("Validation Error: Album ID must be greater than 0.");
            return false;
        }

        try {

            Connection conn = DBConnection.getConnection();

            String sql =
                    "DELETE FROM albums WHERE album_id = ?";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, albumId);

            int rows = pst.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}