package com.workat.model;

import java.util.UUID;

public class Player {
    private final UUID id;
    private final String name;
    private int position;

    public Player(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.position = 0;
    }

    public UUID getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getPosition(){
        return position;
    }

    public void setPosition(int pos){
        position = pos;
    }
}
