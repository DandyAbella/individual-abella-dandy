package com.joysistvi.recordingstudio.repository;

import com.joysistvi.recordingstudio.config.DBConnection;
import com.joysistvi.recordingstudio.model.Playlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlaylistRepositoryImpl
        implements PlaylistRepository {

    @Override
    public List<Playlist> findAll() {

        List<Playlist> playlists =
                new ArrayList<>();

        String sql =
                "SELECT * FROM playlists";

        try (
                Connection conn =
                        DBConnection.getConnection();

                PreparedStatement ps =
                        conn.prepareStatement(sql);

                ResultSet rs =
                        ps.executeQuery()
        ) {

            while(rs.next()) {

                Playlist playlist =
                        new Playlist();

                playlist.setPlaylistId(
                        rs.getInt("playlist_id")
                );

                playlist.setPlaylistName(
                        rs.getString("playlist_name")
                );

                playlists.add(playlist);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return playlists;
    }

    @Override
    public void save(Playlist playlist) {

        String sql =
                "INSERT INTO playlists(playlist_name) VALUES(?)";

        try (
                Connection conn =
                        DBConnection.getConnection();

                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setString(
                    1,
                    playlist.getPlaylistName()
            );

            ps.executeUpdate();

            System.out.println("Playlist Created.");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int playlistId) {

        String sql =
                "DELETE FROM playlists WHERE playlist_id=?";

        try (
                Connection conn =
                        DBConnection.getConnection();

                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setInt(1, playlistId);

            ps.executeUpdate();

            System.out.println("Playlist Deleted.");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}