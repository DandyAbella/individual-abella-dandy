package com.prestigegym.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {

    private int id;
    private int reservationId;
    private int modeOfPaymentId;
    private BigDecimal amount;
    private String paymentStatus;
    private String referenceNumber;
    private LocalDateTime paidAt;

    public Payment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getModeOfPaymentId() {
        return modeOfPaymentId;
    }

    public void setModeOfPaymentId(int modeOfPaymentId) {
        this.modeOfPaymentId = modeOfPaymentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public LocalDateTime getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(LocalDateTime paidAt) {
        this.paidAt = paidAt;
    }
}