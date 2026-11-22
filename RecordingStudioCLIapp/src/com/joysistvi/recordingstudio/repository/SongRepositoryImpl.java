package com.joysistvi.recordingstudio.repository;

import com.joysistvi.recordingstudio.config.DBConnection;
import com.joysistvi.recordingstudio.model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongRepositoryImpl implements SongRepository {

    @Override
    public List<Song> findAll() {

        List<Song> songs = new ArrayList<>();

        String sql = "SELECT * FROM songs";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Song song = new Song();

                song.setSongId(rs.getInt("song_id"));
                song.setSongTitle(rs.getString("song_title"));
                song.setArtistId(rs.getInt("artist_id"));
                song.setAlbumId(rs.getInt("album_id"));
                song.setDuration(rs.getString("duration"));

                songs.add(song);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return songs;
    }

    @Override
    public void save(Song song) {

        String sql =
                "INSERT INTO songs(song_title,artist_id,album_id,duration) VALUES(?,?,?,?)";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, song.getSongTitle());
            ps.setInt(2, song.getArtistId());
            ps.setInt(3, song.getAlbumId());
            ps.setString(4, song.getDuration());

            ps.executeUpdate();

            System.out.println("Song Added.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int songId) {

        String sql =
                "DELETE FROM songs WHERE song_id=?";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, songId);

            ps.executeUpdate();

            System.out.println("Song Deleted.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Song> searchSongs(String keyword) {

        List<Song> songs = new ArrayList<>();

        String sql =
                "SELECT * FROM songs WHERE song_title LIKE ?";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1,"%"+keyword+"%");

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Song song = new Song();

                song.setSongId(rs.getInt("song_id"));
                song.setSongTitle(rs.getString("song_title"));
                song.setArtistId(rs.getInt("artist_id"));
                song.setAlbumId(rs.getInt("album_id"));
                song.setDuration(rs.getString("duration"));

                songs.add(song);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return songs;
    }
}