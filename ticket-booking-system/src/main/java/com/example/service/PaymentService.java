package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.example.enums.PaymentStatus;
import com.example.model.Payment;

public class PaymentService {
    List<Payment> payments = new ArrayList<>();

    public Payment processPayment(String bookingId, double amount) {
        Payment payment = new Payment(UUID.randomUUID().toString(), bookingId, amount);

        // simulation
        boolean success = new Random().nextBoolean();

        if(success) {
            payment.setStatus(PaymentStatus.SUCCESS);
            System.out.println("Payment successful for Booking: " + bookingId);
        } else{
            payment.setStatus(PaymentStatus.FAILED);
            System.out.println("Payment failed for Booking: " + bookingId);
        }

        payments.add(payment);
        return payment;
    }

    public Payment getPaymentByBooking(String bookingId){
        return payments.stream()
                .filter(p -> p.getBookingId().equals(bookingId))
                .findFirst()
                .orElse(null);
    }
}
