package com.example.model;

import java.util.List;

import com.example.enums.BookingStatus;

public class Booking {
    private String id;
    private String userId;
    private String showId;
    private List<String> seatIds;
    private BookingStatus status;

    public Booking(String id, String userId, String showId, List<String> seatIds){
        this.id = id;
        this.userId = userId;
        this.showId = showId;
        this.seatIds = seatIds;
        this.status = BookingStatus.PENDING;
    }

    public String getId(){
        return id;
    }

    public String getUserId(){
        return userId;
    }

    public String getShowId() {
        return showId;
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
