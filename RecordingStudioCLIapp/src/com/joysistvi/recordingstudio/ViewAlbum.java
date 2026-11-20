package com.joysistvi.recordingstudio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewAlbum {

    public static void viewAlbums() {

        try {

            Connection conn = DBConnection.getConnection();

            String sql =
                    "SELECT a.album_id, a.album_title, " +
                            "a.release_year, ar.artist_name " +
                            "FROM albums a " +
                            "INNER JOIN artists ar " +
                            "ON a.artist_id = ar.artist_id";

            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            System.out.println("\n===== ALBUM LIST =====");

            while (rs.next()) {

                System.out.println(
                        "Album ID: " + rs.getInt("album_id")
                                + " | Title: " + rs.getString("album_title")
                                + " | Year: " + rs.getInt("release_year")
                                + " | Artist: " + rs.getString("artist_name")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}