package com.example.model;

import com.example.enums.PaymentStatus;

public class Payment {
    private String id;
    private String bookingId;
    private double amount;
    private PaymentStatus status;

    public Payment(String id, String bookingId, double amount){
        this.id = id;
        this.bookingId = bookingId;
        this.amount = amount;
        this.status = PaymentStatus.PENDING;
    }

    public String getId() {
        return id;
    }

    public String getBookingId() {
        return bookingId;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}
