package com.prestigegym.repository;

import com.prestigegym.config.DBConnection;

import java.sql.*;

public class DashboardRepositoryImpl
        implements DashboardRepository {

    @Override
    public int getTotalMembers() {

        String sql =
                "SELECT COUNT(*) FROM members WHERE is_archived = 0";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int getActiveMemberships() {

        String sql =
                "SELECT COUNT(*) FROM memberships WHERE status='ACTIVE'";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int getTodayAttendance() {

        String sql =
                "SELECT COUNT(*) FROM attendance WHERE DATE(check_in)=CURDATE()";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public double getTotalRevenue() {

        String sql =
                "SELECT IFNULL(SUM(amount),0) FROM payments";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {

            if (rs.next()) {
                return rs.getDouble(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}