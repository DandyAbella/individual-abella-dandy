package com.joysistvi.recordingstudio.repository;

import com.joysistvi.recordingstudio.config.DBConnection;
import com.joysistvi.recordingstudio.model.Artist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArtistRepositoryImpl implements ArtistRepository {

    @Override
    public List<Artist> findAllActive() {

        List<Artist> artists = new ArrayList<>();

        String sql =
                "SELECT * FROM artists WHERE is_archived = 0";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Artist artist = new Artist();

                artist.setArtistId(rs.getInt("artist_id"));
                artist.setArtistName(rs.getString("artist_name"));
                artist.setGenre(rs.getString("genre"));
                artist.setCountry(rs.getString("country"));
                artist.setArchived(rs.getBoolean("is_archived"));

                artists.add(artist);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return artists;
    }

    @Override
    public List<Artist> findAllArchived() {
        return new ArrayList<>();
    }

    @Override
    public void save(Artist artist) {

        String sql =
                "INSERT INTO artists " +
                        "(artist_name, genre, country, is_archived) " +
                        "VALUES (?, ?, ?, 0)";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, artist.getArtistName());
            ps.setString(2, artist.getGenre());
            ps.setString(3, artist.getCountry());

            ps.executeUpdate();

            System.out.println("Artist added successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Artist artist) {

        String sql =
                "UPDATE artists " +
                        "SET artist_name = ?, genre = ?, country = ? " +
                        "WHERE artist_id = ?";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setString(1, artist.getArtistName());
            ps.setString(2, artist.getGenre());
            ps.setString(3, artist.getCountry());
            ps.setInt(4, artist.getArtistId());

            ps.executeUpdate();

            System.out.println("Artist updated.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int artistId) {

        String sql =
                "DELETE FROM artists " +
                        "WHERE artist_id = ?";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setInt(1, artistId);

            ps.executeUpdate();

            System.out.println("Artist deleted.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void archiveById(int artistId) {

        String sql =
                "UPDATE artists " +
                        "SET is_archived = 1 " +
                        "WHERE artist_id = ?";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setInt(1, artistId);

            ps.executeUpdate();

            System.out.println("Artist archived.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void restoreById(int artistId) {

        String sql =
                "UPDATE artists SET is_archived = 0 " +
                        "WHERE artist_id = ?";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setInt(1, artistId);

            ps.executeUpdate();

            System.out.println("Artist restored.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Artist> searchByName(String keyword) {

        List<Artist> artists = new ArrayList<>();

        String sql =
                "SELECT * FROM artists " +
                        "WHERE artist_name LIKE ? " +
                        "AND is_archived = 0";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setString(1, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Artist artist = new Artist();

                artist.setArtistId(rs.getInt("artist_id"));
                artist.setArtistName(rs.getString("artist_name"));
                artist.setGenre(rs.getString("genre"));
                artist.setCountry(rs.getString("country"));
                artist.setArchived(rs.getBoolean("is_archived"));

                artists.add(artist);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return artists;
    }
}