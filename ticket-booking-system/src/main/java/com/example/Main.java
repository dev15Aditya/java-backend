package com.example;

import java.util.Arrays;
import java.util.List;

import com.example.enums.UpdateSeat;
import com.example.model.Booking;
import com.example.model.Seat;
import com.example.model.Show;
import com.example.service.BookingService;

public class Main {
    public static void main(String[] args) {
        List<Seat> seats = Arrays.asList(
            new Seat("A1", 200),
            new Seat("A2", 200),
            new Seat("A3", 200)
        );

        Show show = new Show("S1", "SpiderMan Late Home", "7:00 PM", seats);
        // Screen screen = new Screen("SCR1", "Screen 1", Arrays.asList(show));

        // Theatre theatre = new Theatre("T1", "PVR Cinema", Arrays.asList(screen));

        // System.out.println(theatre.getName());
        // System.out.println(show.getMovieName());
        // System.out.println(show.getSeats().size());

        BookingService bookingService = new BookingService();

        Booking b1 = bookingService.createBooking("user1", show, Arrays.asList("A1", "A2"));
        Booking b2 = bookingService.createBooking("user2", show, Arrays.asList("A3"));

        bookingService.viewAllBooking();
        bookingService.cancelBooking(b1.getId());

        bookingService.seatUpdate(b2.getId(), "A1", UpdateSeat.ADD);
        bookingService.viewAllBooking();
    }
}