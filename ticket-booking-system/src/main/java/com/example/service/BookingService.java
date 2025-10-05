package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.enums.BookingStatus;
import com.example.enums.PaymentStatus;
import com.example.enums.UpdateSeat;
import com.example.model.Booking;
import com.example.model.Payment;
import com.example.model.Seat;
import com.example.model.Show;

public class BookingService {
    private final List<Booking> bookings = new ArrayList<>();
    PaymentService paymentService = new PaymentService();

    public Booking createBooking(String userId, Show show, List<String> seatIds){
        for(String seatId: seatIds){
            boolean exits = show.getSeats().stream()
                .anyMatch(seat -> seat.getId().equals(seatId));

            if(!exits) {
                throw new IllegalArgumentException("Seat ID not found: " + seatId);
            }
        }

        String bookingId = UUID.randomUUID().toString();
        Booking booking = new Booking(bookingId, userId, show, seatIds);

        bookings.add(booking);

        System.out.println("Booking created: " + bookingId + " for seats " + seatIds);
        return booking;
    }

    public void confirmBooking(String bookingId, double amount){
        for(Booking booking: bookings){
            if(booking.getId().equals(bookingId)){
                Show show = booking.getShow();
                List<Seat> bookedSeats = new ArrayList<>(show.getSeats());
                double totalPrice = 0;

                for(String seatId: booking.getSeatIds()){
                    for(Seat seat: bookedSeats){
                        if(seatId.equals(seat.getId())){
                            totalPrice += seat.getPrice();
                        }
                    }
                }

                if(totalPrice > amount){
                    System.out.println("Insufficient Balance. Required amount: " + totalPrice);
                    return;
                }

                Payment payment = paymentService.processPayment(bookingId, amount);

                if(payment.getStatus() == PaymentStatus.SUCCESS){
                    booking.setStatus(BookingStatus.CONFIRMED);
                    System.out.println("Booking: " + bookingId + " | Status: " + BookingStatus.CONFIRMED);
                } else {
                    booking.setStatus(BookingStatus.CANCELLED);
                    System.out.println("Booking: " + bookingId + " | Status: " + BookingStatus.CANCELLED);
                }

                return;
            }
        }

        System.out.println("No Booking: " + bookingId + " found");
    }

    public void seatUpdate(String bookingId, String seatId, UpdateSeat op){
        for(Booking b: bookings){
            
            if(b.getId().equals(bookingId)){
                List<String> existingSeatIds = new ArrayList<>(b.getSeatIds());

                switch (op) {
                    case ADD -> {
                        if(!existingSeatIds.contains(seatId)) {
                            existingSeatIds.add(seatId);
                            System.out.println("Seat: " + seatId + " added to Booking: " + bookingId);
                        } else {
                            System.out.println("Seat: " + seatId + " is already present in Booking: " + bookingId);
                        }
                    }
                    case REMOVE -> {
                        if(!existingSeatIds.contains(seatId)){
                            System.out.println("Seat: " + seatId + " not found in Booking: " + bookingId);
                        } else {
                            existingSeatIds.remove(seatId);
                            System.out.println("Seat: " + seatId + " removed from Booking: " + bookingId);
                        }
                    }
                    default -> throw new IllegalArgumentException("Invalid update operation, use (ADD/REMOVE)");
                }

                b.setSeatIds(existingSeatIds);
                // System.out.println("Booking: " + bookingId + " | Seat: " + seatId + op + "ED");
                System.out.println("Booking: " + bookingId + " updated!");
            }
            // Booking temp = b;
            // bookings.remove(b);
            // temp.setSeatIds(existingSeatIds);
            // bookings.add(temp);
            return;
        }
    }

    public boolean cancelBooking(String bookingId){
        Optional<Booking> bookOptional = bookings.stream()
                .filter(b -> b.getId().equals(bookingId))
                .findFirst();
        if(bookOptional.isEmpty()){
            System.out.println("Booking not found");
            return false;
        }

        bookings.remove(bookOptional.get());
        System.out.println("Booking canceled: " + bookingId);
        return true;
    }

    public void viewAllBooking() {
        if(bookings.isEmpty()){
            System.out.println("No bookings yet!");
            return;
        }

        System.out.println("All bookings: ");
        for(Booking booking: bookings){
            System.out.println("Booking: " + booking.getId()+ 
                ", User: " + booking.getUserId() + 
                ", Show: " + booking.getShow().getId() +
                ", Seats: " + booking.getSeatIds() +
                ", Status: " + booking.getStatus());
        }
    }
}
