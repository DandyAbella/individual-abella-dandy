package com.prestigegym.repository;

import com.prestigegym.config.DBConnection;
import com.prestigegym.model.Payment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepositoryImpl
        implements PaymentRepository {

    @Override
    public List<Payment> findAll() {

        return new ArrayList<>();
    }

    @Override
    public Payment findById(int id) {

        return null;
    }

    @Override
    public void save(Payment payment) {

        String sql =
                "INSERT INTO payments " +
                        "(reservation_id, modeofpayment_id, amount, payment_status, reference_number, paid_at) " +
                        "VALUES (?, ?, ?, ?, ?, NOW())";

        try (
                Connection conn =
                        DBConnection.getConnection();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setInt(1,
                    payment.getReservationId());

            stmt.setInt(2,
                    payment.getModeOfPaymentId());

            stmt.setBigDecimal(3,
                    payment.getAmount());

            stmt.setString(4,
                    payment.getPaymentStatus());

            stmt.setString(5,
                    payment.getReferenceNumber());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}