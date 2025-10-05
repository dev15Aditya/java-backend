package com.example;

import java.util.Arrays;
import java.util.List;

import com.example.model.Screen;
import com.example.model.Seat;
import com.example.model.Show;
import com.example.model.Theatre;

public class Main {
    public static void main(String[] args) {
        List<Seat> seats = Arrays.asList(
            new Seat("A1", 200),
            new Seat("A2", 200),
            new Seat("A3", 200)
        );

        Show show = new Show("S1", "SpiderMan Late Home", "7:00 PM", seats);
        Screen screen = new Screen("SCR1", "Screen 1", Arrays.asList(show));

        Theatre theatre = new Theatre("T1", "PVR Cinema", Arrays.asList(screen));

        System.out.println(theatre.getName());
        System.out.println(show.getMovieName());
        System.out.println(show.getSeats().size());
    }
}