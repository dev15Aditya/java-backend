package com.workat.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.workat.model.Player;

public class IO {

    Scanner sc;

    public IO() {
        sc = new Scanner(System.in);
    }
    
    public Map<Integer, Integer> ladderInput(){
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println("==========SNAKE INPUT===========");
        System.out.print("Enter number of snakes on board: ");
        int n = sc.nextInt();

        System.out.println();
        System.out.println("Now enter HEAD & TAIL of each " +n+ " snakes.");

        while(n-- > 0){
            int head = sc.nextInt();
            int tail = sc.nextInt();
            map.put(head, tail);
        }

        return map;
    }

    public Map<Integer, Integer> snakeInput(){
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println("==========LADDER INPUT===========");
        System.out.print("Enter number of ladders on board: ");
        int n = sc.nextInt();

        System.out.println();
        System.out.println("Now enter START & END of each " +n+ " ladders.");

        while(n-- > 0){
            int start = sc.nextInt();
            int end = sc.nextInt();
            map.put(start, end);
        }

        return map;
    }

    public List<Player> playerInput(){
        List<Player> players = new ArrayList<>();
        System.out.println("==========PLAYER INPUT===========");
        System.out.print("Enter number of players: ");
        int n = sc.nextInt();

        System.out.println();
        System.out.println("Now enter name of each " + n + " player.");

        while(n-- > 0){
            String name = sc.next();
            players.add(new Player(name));
        }

        return players;
    }
}
