package com.example.model;

import java.util.List;

public class Booking {
    private String id;
    private String userId;
    private String showId;
    private List<String> seatIds;

    public Booking(String id, String userId, String showId, List<String> seatIds){
        this.id = id;
        this.userId = userId;
        this.showId = showId;
        this.seatIds = seatIds;
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
}
