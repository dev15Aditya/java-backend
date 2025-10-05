package com.example.model;

import java.util.List;

public class Show {
    private String id;
    private String movieName;
    private String startTime;
    private List<Seat> seats;

    public Show(String id, String movieName, String startTime, List<Seat> seats){
        this.id = id;
        this.movieName = movieName;
        this.startTime = startTime;
        this.seats = seats;
    }

    public String getId() {
        return id;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getStartTime() {
        return startTime;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
