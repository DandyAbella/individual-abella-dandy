package com.prestigegym.repository;

import com.prestigegym.config.DBConnection;
import com.prestigegym.model.Attendance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceRepositoryImpl
        implements AttendanceRepository {

    @Override
    public List<Attendance> findAll() {

        List<Attendance> attendances =
                new ArrayList<>();

        String sql = "SELECT * FROM attendance";

        try (
                Connection conn =
                        DBConnection.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(sql);
                ResultSet rs =
                        stmt.executeQuery()
        ) {

            while (rs.next()) {

                Attendance attendance =
                        new Attendance();

                attendance.setId(
                        rs.getInt("id"));

                attendance.setMemberId(
                        rs.getInt("member_id"));

                if (rs.getTimestamp("check_in") != null) {
                    attendance.setCheckIn(
                            rs.getTimestamp("check_in")
                                    .toLocalDateTime());
                }

                if (rs.getTimestamp("check_out") != null) {
                    attendance.setCheckOut(
                            rs.getTimestamp("check_out")
                                    .toLocalDateTime());
                }

                attendances.add(attendance);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return attendances;
    }

    @Override
    public void checkIn(int memberId) {

        String sql =
                "INSERT INTO attendance(member_id,check_in) VALUES(?,NOW())";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, memberId);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void checkOut(int attendanceId) {

        String sql =
                "UPDATE attendance SET check_out = NOW() WHERE id=?";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, attendanceId);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}