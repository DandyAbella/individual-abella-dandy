package com.joysistvi.recordingstudio;

import com.joysistvi.recordingstudio.config.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeletePlaylist {

    public static boolean deletePlaylist(int playlistId) {

        // Guard Clause / Validation

        if (playlistId <= 0) {
            System.out.println("Validation Error: Playlist ID must be greater than 0.");
            return false;
        }

        try {

            Connection conn = DBConnection.getConnection();

            String sql1 =
                    "DELETE FROM playlist_songs WHERE playlist_id = ?";

            PreparedStatement pst1 =
                    conn.prepareStatement(sql1);

            pst1.setInt(1, playlistId);
            pst1.executeUpdate();

            String sql2 =
                    "DELETE FROM playlists WHERE playlist_id = ?";

            PreparedStatement pst2 =
                    conn.prepareStatement(sql2);

            pst2.setInt(1, playlistId);

            int rows = pst2.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }
}