package com.joysistvi.recordingstudio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewSong {

    public static void viewSongs() {

        try {

            Connection conn = DBConnection.getConnection();

            String sql =
                    "SELECT s.song_id, s.song_title, s.duration, " +
                            "a.album_title, a.release_year, " +
                            "ar.artist_name, ar.genre " +
                            "FROM songs s " +
                            "JOIN albums a ON s.album_id = a.album_id " +
                            "JOIN artists ar ON a.artist_id = ar.artist_id";

            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            System.out.println("\n===== SONG LIST =====");

            while(rs.next()) {

                System.out.println(
                        "ID: " + rs.getInt("song_id")
                                + " | Song: " + rs.getString("song_title")
                                + " | Artist: " + rs.getString("artist_name")
                                + " | Album: " + rs.getString("album_title")
                                + " | Genre: " + rs.getString("genre")
                                + " | Year: " + rs.getInt("release_year")
                                + " | Duration: " + rs.getString("duration")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}