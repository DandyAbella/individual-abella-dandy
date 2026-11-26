package com.prestigegym.repository;

import com.prestigegym.config.DBConnection;
import com.prestigegym.model.MembershipPlan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MembershipPlanRepositoryImpl
        implements MembershipPlanRepository {

    @Override
    public List<MembershipPlan> findAll() {

        List<MembershipPlan> plans =
                new ArrayList<>();

        String sql =
                "SELECT * FROM membership_plans " +
                        "WHERE is_archived = 0";

        try (
                Connection conn =
                        DBConnection.getConnection();

                PreparedStatement stmt =
                        conn.prepareStatement(sql);

                ResultSet rs =
                        stmt.executeQuery()
        ) {

            while (rs.next()) {

                MembershipPlan plan =
                        new MembershipPlan();

                plan.setId(rs.getInt("id"));
                plan.setPlanName(rs.getString("plan"));
                plan.setDurationMonths(
                        rs.getInt("duration_months"));
                plan.setPrice(
                        rs.getDouble("price"));

                plans.add(plan);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return plans;
    }
}