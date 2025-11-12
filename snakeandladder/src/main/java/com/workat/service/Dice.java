package com.workat.service;

import java.util.Random;

public class Dice {
    private Random rand = new Random();
    private final int range;

    public Dice() {
        this.range = 6;
    }

    public int roll(){
        int randomInt = rand.nextInt(range) + 1;
        return randomInt;
    }
}
