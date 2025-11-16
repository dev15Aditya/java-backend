package com.workat.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.workat.dto.ExpenseRequestDTO;
import com.workat.entity.SplitType;

public class IO {
    Scanner sc = new Scanner(System.in);
    Ledger ledger = new Ledger();
    Validators validator = new Validators();

    public IO() {
        System.out.println("_____SPLIT WISE_____");
    }
    
    public void start(){
        while(sc.hasNextLine()){
            String line = sc.nextLine().trim();
            if(line.isEmpty()) continue;
            
            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            try {
                switch (command) {
                    case "SHOW" -> {
                        if(tokens.length == 1) {
                            ledger.show();
                        } else {
                            ledger.showOne(tokens[1]);
                        }
                    }
                    case "EXPENSE" -> {
                        // Format: EXPENSE <payer-id> <amount> <no-of-users> <user-ids...> <EQUAL/EXACT/PERCENT> <values...>
                        String payerId = tokens[1];
                        double amount = Double.parseDouble(tokens[2]);
                        int numUsers = Integer.parseInt(tokens[3]);
                        
                        List<String> participants = new ArrayList<>();
                        for(int i = 4; i < 4 + numUsers; i++){
                            participants.add(tokens[i]);
                        }
                        
                        String typeStr = tokens[4 + numUsers];
                        SplitType splitType = SplitType.valueOf(typeStr);
                        
                        List<Double> values = new ArrayList<>();
                        if(splitType == SplitType.EQUAL) {
                            // For EQUAL, no values needed
                        } else {
                            // For EXACT or PERCENT, read the values
                            for(int i = 5 + numUsers; i < tokens.length; i++){
                                values.add(Double.parseDouble(tokens[i]));
                            }
                            
                            // Validate
                            if(splitType == SplitType.PERCENT) {
                                validator.validatePercentage(values);
                            } else if(splitType == SplitType.EXACT) {
                                validator.validateExactAmount(values, amount);
                            }
                        }
                        
                        ExpenseRequestDTO ex = new ExpenseRequestDTO(
                            "exp_" + System.currentTimeMillis(), 
                            payerId, 
                            amount, 
                            participants, 
                            splitType, 
                            values, 
                            new Date()
                        );
                        ledger.addExpense(ex);
                    }
                    default -> System.out.println("Unknown command: " + command);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
