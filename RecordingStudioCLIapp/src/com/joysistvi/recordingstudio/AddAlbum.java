package com.joysistvi.recordingstudio;

import com.joysistvi.recordingstudio.config.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddAlbum {

    public static boolean addAlbum(
            String albumTitle,
            int releaseYear,
            int artistId) {

        // Guard Clauses / Validation

        if (albumTitle == null || albumTitle.trim().isEmpty()) {
            System.out.println("Validation Error: Album title is required.");
            return false;
        }

        if (releaseYear < 1900 || releaseYear > 2100) {
            System.out.println("Validation Error: Release year must be between 1900 and 2100.");
            return false;
        }

        if (artistId <= 0) {
            System.out.println("Validation Error: Artist ID must be greater than 0.");
            return false;
        }

        try {

            Connection conn = DBConnection.getConnection();

            String sql =
                    "INSERT INTO albums(album_title, release_year, artist_id) " +
                            "VALUES (?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, albumTitle);
            pst.setInt(2, releaseYear);
            pst.setInt(3, artistId);

            int rows = pst.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}