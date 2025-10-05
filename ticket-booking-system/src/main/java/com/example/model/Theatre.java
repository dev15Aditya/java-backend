package com.example.model;

import java.util.List;

public class Theatre {
    private String id;
    private String name;
    private List<Screen> screens;

    public Theatre(String id, String name, List<Screen> screens){
        this.id = id;
        this.name = name;
        this.screens = screens;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Screen> getScreens(){
        return screens;
    }
}
