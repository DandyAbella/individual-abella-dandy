package com.prestigegym.repository;

import com.prestigegym.config.DBConnection;
import com.prestigegym.model.Membership;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MembershipRepositoryImpl implements MembershipRepository {

    @Override
    public List<Membership> findAll() {

        List<Membership> memberships = new ArrayList<>();

        String sql = "SELECT * FROM memberships";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {

            while (rs.next()) {

                Membership membership = new Membership();

                membership.setId(rs.getInt("id"));
                membership.setMemberId(rs.getInt("member_id"));
                membership.setPlanId(rs.getInt("plan_id"));
                membership.setStartDate(
                        rs.getDate("start_date").toLocalDate()
                );
                membership.setEndDate(
                        rs.getDate("end_date").toLocalDate()
                );
                membership.setStatus(
                        rs.getString("status")
                );

                memberships.add(membership);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return memberships;
    }

    @Override
    public Membership findById(int id) {

        String sql =
                "SELECT * FROM memberships WHERE id=?";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Membership membership = new Membership();

                membership.setId(rs.getInt("id"));
                membership.setMemberId(rs.getInt("member_id"));
                membership.setPlanId(rs.getInt("plan_id"));
                membership.setStartDate(
                        rs.getDate("start_date").toLocalDate()
                );
                membership.setEndDate(
                        rs.getDate("end_date").toLocalDate()
                );
                membership.setStatus(
                        rs.getString("status")
                );

                return membership;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void save(Membership membership) {

        String sql =
                "INSERT INTO memberships(member_id,plan_id,start_date,end_date,status) VALUES(?,?,?,?,?)";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, membership.getMemberId());
            stmt.setInt(2, membership.getPlanId());
            stmt.setDate(
                    3,
                    Date.valueOf(
                            membership.getStartDate()
                    )
            );
            stmt.setDate(
                    4,
                    Date.valueOf(
                            membership.getEndDate()
                    )
            );
            stmt.setString(
                    5,
                    membership.getStatus()
            );

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Membership membership) {

        String sql =
                "UPDATE memberships SET status=? WHERE id=?";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setString(
                    1,
                    membership.getStatus()
            );

            stmt.setInt(
                    2,
                    membership.getId()
            );

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cancel(int id) {

        String sql =
                "UPDATE memberships SET status='CANCELLED' WHERE id=?";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}