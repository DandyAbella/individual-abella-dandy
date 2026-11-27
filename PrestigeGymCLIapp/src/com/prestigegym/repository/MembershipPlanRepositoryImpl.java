package com.prestigegym.repository;

import com.prestigegym.config.DBConnection;
import com.prestigegym.model.MembershipPlan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MembershipPlanRepositoryImpl implements MembershipPlanRepository {

    @Override
    public List<MembershipPlan> findAll() {
        List<MembershipPlan> plans = new ArrayList<>();

        String sql = "SELECT * FROM membership_plans";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                MembershipPlan plan = new MembershipPlan();
                plan.setId(rs.getInt("id"));
                plan.setPlanName(rs.getString("plan"));
                plan.setDurationMonths(rs.getInt("duration_months"));
                plan.setPrice(rs.getDouble("price"));

                plans.add(plan);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return plans;
    }

    @Override
    public MembershipPlan findById(int id) {
        String sql = "SELECT * FROM membership_plans WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                MembershipPlan plan = new MembershipPlan();

                plan.setId(rs.getInt("id"));
                plan.setPlanName(rs.getString("plan"));
                plan.setDurationMonths(rs.getInt("duration_months"));
                plan.setPrice(rs.getDouble("price"));

                return plan;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void save(MembershipPlan plan) {
        String sql = "INSERT INTO membership_plans(plan,duration_months,price) VALUES(?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, plan.getPlanName());
            stmt.setInt(2, plan.getDurationMonths());
            stmt.setDouble(3, plan.getPrice());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(MembershipPlan plan) {
        String sql = "UPDATE membership_plans SET plan=?, duration_months=?, price=? WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, plan.getPlanName());
            stmt.setInt(2, plan.getDurationMonths());
            stmt.setDouble(3, plan.getPrice());
            stmt.setInt(4, plan.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM membership_plans WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}