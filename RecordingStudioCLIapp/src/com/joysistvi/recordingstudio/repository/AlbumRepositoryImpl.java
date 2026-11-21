package com.joysistvi.recordingstudio.repository;

import com.joysistvi.recordingstudio.config.DBConnection;
import com.joysistvi.recordingstudio.model.Album;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlbumRepositoryImpl implements AlbumRepository {

    @Override
    public List<Album> findAllActive() {

        List<Album> albums = new ArrayList<>();

        String sql =
                "SELECT a.*, ar.artist_name " +
                        "FROM albums a " +
                        "JOIN artists ar " +
                        "ON a.artist_id = ar.artist_id " +
                        "WHERE a.is_archived = 0";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps =
                        conn.prepareStatement(sql);
                ResultSet rs =
                        ps.executeQuery()
        ) {

            while (rs.next()) {

                Album album = new Album();

                album.setAlbumId(
                        rs.getInt("album_id"));

                album.setAlbumName(
                        rs.getString("album_title"));

                album.setYear(
                        rs.getInt("release_year"));

                album.setArtistId(
                        rs.getInt("artist_id"));

                album.setArtistName(
                        rs.getString("artist_name"));

                album.setArchived(
                        rs.getBoolean("is_archived"));

                albums.add(album);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return albums;
    }

    @Override
    public List<Album> findAllArchived() {

        List<Album> albums = new ArrayList<>();

        String sql =
                "SELECT a.*, ar.artist_name " +
                        "FROM albums a " +
                        "JOIN artists ar " +
                        "ON a.artist_id = ar.artist_id " +
                        "WHERE a.is_archived = 1";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Album album = new Album();

                album.setAlbumId(rs.getInt("album_id"));
                album.setAlbumName(rs.getString("album_title"));
                album.setYear(rs.getInt("release_year"));
                album.setArtistId(rs.getInt("artist_id"));
                album.setArtistName(rs.getString("artist_name"));
                album.setArchived(rs.getBoolean("is_archived"));

                albums.add(album);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return albums;
    }

    @Override
    public void save(Album album) {

        String sql =
                "INSERT INTO albums " +
                        "(album_title, release_year, artist_id, is_archived) " +
                        "VALUES (?, ?, ?, 0)";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setString(1, album.getAlbumName());
            ps.setInt(2, album.getYear());
            ps.setInt(3, album.getArtistId());

            ps.executeUpdate();

            System.out.println("Album added successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Album album) {

        String sql =
                "UPDATE albums " +
                        "SET album_title = ?, release_year = ?, artist_id = ? " +
                        "WHERE album_id = ?";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setString(1, album.getAlbumName());
            ps.setInt(2, album.getYear());
            ps.setInt(3, album.getArtistId());
            ps.setInt(4, album.getAlbumId());

            ps.executeUpdate();

            System.out.println("Album updated.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int albumId) {

        String sql =
                "DELETE FROM albums " +
                        "WHERE album_id = ?";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setInt(1, albumId);

            ps.executeUpdate();

            System.out.println("Album deleted.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void archiveById(int albumId) {

        String sql =
                "UPDATE albums " +
                        "SET is_archived = 1 " +
                        "WHERE album_id = ?";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setInt(1, albumId);

            ps.executeUpdate();

            System.out.println("Album archived.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void restoreById(int albumId) {

        String sql =
                "UPDATE albums " +
                        "SET is_archived = 0 " +
                        "WHERE album_id = ?";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setInt(1, albumId);

            ps.executeUpdate();

            System.out.println("Album restored.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Album> searchByName(String keyword) {

        List<Album> albums = new ArrayList<>();

        String sql =
                "SELECT a.*, ar.artist_name " +
                        "FROM albums a " +
                        "JOIN artists ar " +
                        "ON a.artist_id = ar.artist_id " +
                        "WHERE a.album_title LIKE ? " +
                        "AND a.is_archived = 0";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setString(1, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Album album = new Album();

                album.setAlbumId(rs.getInt("album_id"));
                album.setAlbumName(rs.getString("album_title"));
                album.setYear(rs.getInt("release_year"));
                album.setArtistId(rs.getInt("artist_id"));
                album.setArtistName(rs.getString("artist_name"));
                album.setArchived(rs.getBoolean("is_archived"));

                albums.add(album);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return albums;
    }
}