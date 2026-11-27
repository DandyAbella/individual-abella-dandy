package com.prestigegym.service;

import com.prestigegym.model.Payment;
import java.util.List;

public interface PaymentService {

    List<Payment> getAllPayments();

    Payment getPaymentById(int id);

    void addPayment(Payment payment);
}