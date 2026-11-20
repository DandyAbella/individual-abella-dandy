package com.joysistvi.recordingstudio;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddSongToPlaylist {

    public static boolean addSongToPlaylist(
            int playlistId,
            int songId) {

        try {

            Connection conn = DBConnection.getConnection();

            String sql =
                    "INSERT INTO playlist_songs " +
                            "(playlist_id, song_id) " +
                            "VALUES (?, ?)";

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, playlistId);
            pst.setInt(2, songId);

            int rows = pst.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }
}