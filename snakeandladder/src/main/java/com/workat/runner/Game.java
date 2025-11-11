package com.workat.runner;

import java.util.List;
import java.util.Map;

import com.workat.model.Player;
import com.workat.service.IO;

public class Game {
    private Map<Integer, Integer> snakeMap;
    private Map<Integer, Integer> ladderMap;
    private List<Player> players;

    private final int BOARD_SIZE = 100;
    private boolean won;

    IO io = new IO();

    public Game() {
        snakeMap = io.snakeInput();
        ladderMap = io.ladderInput();
        players = io.playerInput();
    }

    
}
