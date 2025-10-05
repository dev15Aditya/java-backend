package com.example.model;

import java.util.List;

public class Screen {
    private String id;
    private String name;
    private List<Show> shows;

    public Screen(String id, String name, List<Show> shows){
        this.id = id;
        this.name = name;
        this.shows = shows;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Show> getShows() {
        return shows;
    }
}
