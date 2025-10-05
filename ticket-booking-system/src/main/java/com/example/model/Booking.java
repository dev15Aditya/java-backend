package com.example.model;

import java.util.List;

import com.example.enums.BookingStatus;

public class Booking {
    private String id;
    private String userId;
    private Show show;
    private List<String> seatIds;
    private BookingStatus status;

    public Booking(String id, String userId, Show show, List<String> seatIds){
        this.id = id;
        this.userId = userId;
        this.show = show;
        this.seatIds = seatIds;
        this.status = BookingStatus.PENDING;
    }

    public String getId(){
        return id;
    }

    public String getUserId(){
        return userId;
    }

    public Show getShow() {
        return show;
    }

    public List<String> getSeatIds() {
        return seatIds;
    }

    public void setSeatIds(List<String> seatIds) {
        this.seatIds = seatIds;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
