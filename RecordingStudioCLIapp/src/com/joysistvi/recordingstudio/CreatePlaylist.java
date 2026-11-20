package com.joysistvi.recordingstudio;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CreatePlaylist {

    public static boolean createPlaylist(String playlistName) {

        try {

            Connection conn = DBConnection.getConnection();

            String sql =
                    "INSERT INTO playlists(playlist_name) VALUES(?)";

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, playlistName);

            int rows = pst.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }
}