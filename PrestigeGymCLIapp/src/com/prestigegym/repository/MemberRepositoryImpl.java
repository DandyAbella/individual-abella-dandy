package com.prestigegym.repository;

import com.prestigegym.config.DBConnection;
import com.prestigegym.model.Member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberRepositoryImpl implements MemberRepository {

    @Override
    public List<Member> findAll() {

        List<Member> members = new ArrayList<>();

        String sql =
                "SELECT * FROM members WHERE is_archived = 0";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {

            while (rs.next()) {

                Member member = new Member();

                member.setId(rs.getInt("id"));
                member.setFirstName(
                        rs.getString("first_name")
                );
                member.setLastName(
                        rs.getString("last_name")
                );
                member.setGender(
                        rs.getString("gender")
                );
                member.setContactNumber(
                        rs.getString("contact_number")
                );
                member.setEmail(
                        rs.getString("email")
                );
                member.setAddress(
                        rs.getString("address")
                );

                members.add(member);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return members;
    }

    @Override
    public Member findById(int id) {

        String sql =
                "SELECT * FROM members WHERE id=?";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Member member = new Member();

                member.setId(rs.getInt("id"));
                member.setFirstName(
                        rs.getString("first_name")
                );
                member.setLastName(
                        rs.getString("last_name")
                );
                member.setGender(
                        rs.getString("gender")
                );
                member.setContactNumber(
                        rs.getString("contact_number")
                );
                member.setEmail(
                        rs.getString("email")
                );
                member.setAddress(
                        rs.getString("address")
                );

                return member;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void save(Member member) {

        String sql =
                "INSERT INTO members(first_name,last_name,gender,contact_number,email,address) VALUES(?,?,?,?,?,?)";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setString(1, member.getFirstName());
            stmt.setString(2, member.getLastName());
            stmt.setString(3, member.getGender());
            stmt.setString(4, member.getContactNumber());
            stmt.setString(5, member.getEmail());
            stmt.setString(6, member.getAddress());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Member member) {

        String sql =
                "UPDATE members SET first_name=?,last_name=?,gender=?,contact_number=?,email=?,address=? WHERE id=?";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setString(1, member.getFirstName());
            stmt.setString(2, member.getLastName());
            stmt.setString(3, member.getGender());
            stmt.setString(4, member.getContactNumber());
            stmt.setString(5, member.getEmail());
            stmt.setString(6, member.getAddress());
            stmt.setInt(7, member.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void archive(int id) {

        String sql =
                "UPDATE members SET is_archived = 1 WHERE id=?";

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