package com.prestigegym.repository;

import com.prestigegym.model.Payment;
import java.util.List;

public interface PaymentRepository {

    List<Payment> findAll();

    Payment findById(int id);

    void save(Payment payment);
}