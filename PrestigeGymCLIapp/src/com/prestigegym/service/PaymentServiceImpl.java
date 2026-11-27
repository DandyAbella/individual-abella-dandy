package com.prestigegym.service;

import com.prestigegym.model.Payment;
import com.prestigegym.repository.PaymentRepository;
import com.prestigegym.repository.PaymentRepositoryImpl;

import java.util.List;

public class PaymentServiceImpl
        implements PaymentService {

    private final PaymentRepository repository =
            new PaymentRepositoryImpl();

    @Override
    public List<Payment> getAllPayments() {
        return repository.findAll();
    }

    @Override
    public Payment getPaymentById(int id) {
        return repository.findById(id);
    }

    @Override
    public void addPayment(Payment payment) {
        repository.save(payment);
    }
}