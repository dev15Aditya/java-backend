package com.workat.runner;

import java.util.List;
import java.util.Map;

import com.workat.model.Player;
import com.workat.service.Dice;
import com.workat.service.IO;

public class Game {
    private Map<Integer, Integer> snakeMap;
    private Map<Integer, Integer> ladderMap;
    private List<Player> players;

    private final int BOARD_SIZE = 100;
    private boolean won;

    IO io = new IO();
    Dice dice = new Dice();

    public Game() {
        snakeMap = io.snakeInput();
        ladderMap = io.ladderInput();
        players = io.playerInput();
    }

    public void start(){
        System.out.println("==========STARTING GAME===========");
        while(!won){
            for(Player player: players){
                int roll = dice.roll();
                int currPos = player.getPosition();

                int newPos = roll + currPos;

                if(newPos > BOARD_SIZE) continue;

                if(newPos == BOARD_SIZE){
                    wonMessage(player.getName());
                    won = true;
                    return;
                }
                
                if(snakeMap.containsKey(newPos)){
                    newPos = snakeMap.get(newPos);
                }

                else if(ladderMap.containsKey(newPos)){
                    newPos = ladderMap.get(newPos);
                }

                player.setPosition(newPos);
                
                printCurrMove(player.getName(), roll, newPos);
            }
        }
    }

    private void wonMessage(String name){
        System.out.println("Player " + name + " won the game!");
    }

    private void printCurrMove(String name, int move, int pos){
        System.out.println("Player " + name + " rolled " + move + " | Curr Position: " + pos);
    }
}
