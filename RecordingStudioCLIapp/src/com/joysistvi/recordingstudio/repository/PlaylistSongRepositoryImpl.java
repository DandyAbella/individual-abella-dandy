package com.joysistvi.recordingstudio.repository;

import com.joysistvi.recordingstudio.config.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PlaylistSongRepositoryImpl
        implements PlaylistSongRepository {

    @Override
    public void addSongToPlaylist(
            int playlistId,
            int songId
    ) {

        String sql =
                "INSERT INTO playlist_songs(playlist_id,song_id) VALUES(?,?)";

        try (
                Connection conn =
                        DBConnection.getConnection();

                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setInt(1, playlistId);
            ps.setInt(2, songId);

            ps.executeUpdate();

            System.out.println("Song Added To Playlist");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeSongFromPlaylist(
            int playlistId,
            int songId
    ) {

        String sql =
                "DELETE FROM playlist_songs WHERE playlist_id=? AND song_id=?";

        try (
                Connection conn =
                        DBConnection.getConnection();

                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setInt(1, playlistId);
            ps.setInt(2, songId);

            ps.executeUpdate();

            System.out.println("Song Removed");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}