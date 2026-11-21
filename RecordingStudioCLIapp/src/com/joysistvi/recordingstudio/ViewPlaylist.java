package com.joysistvi.recordingstudio;

import com.joysistvi.recordingstudio.config.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewPlaylist {

    public static void viewPlaylistSongs() {

        try {

            Connection conn = DBConnection.getConnection();

            String sql =
                    "SELECT p.playlist_name, s.song_title, " +
                            "a.album_title, ar.artist_name " +
                            "FROM playlist_songs ps " +
                            "INNER JOIN playlists p " +
                            "ON ps.playlist_id = p.playlist_id " +
                            "INNER JOIN songs s " +
                            "ON ps.song_id = s.song_id " +
                            "INNER JOIN albums a " +
                            "ON s.album_id = a.album_id " +
                            "INNER JOIN artists ar " +
                            "ON a.artist_id = ar.artist_id";

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            System.out.println("\n===== PLAYLIST SONGS =====");

            while (rs.next()) {

                System.out.println(
                        "Playlist: " + rs.getString("playlist_name")
                                + " | Song: " + rs.getString("song_title")
                                + " | Album: " + rs.getString("album_title")
                                + " | Artist: " + rs.getString("artist_name")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}