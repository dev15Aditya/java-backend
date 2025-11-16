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

    public IO() {
        System.out.println("_____SPLIT WISE_____");
        System.out.println("Select the operation: ");
        System.out.println("1. SHOW");
        System.out.println("2. SHOW USER_ID");
        System.out.println("3. EXPENSE (id, payer_id, amount, number of participants, participants_ids, EQUAL/EXACT/PERCENT, values)");
        System.out.println("4. EXIT");
    }
    
    public void start(){
        boolean abort = false;
        
        while(!abort){
            int input = sc.nextInt();

            switch (input) {
                case 4 -> {
                    abort = true;
                    return;
                }
                case 1 -> ledger.show();
                case 2 -> {
                    System.out.println("Enter user id: ");
                    String userId = sc.next();
                    ledger.showOne(userId);
                }
                default -> {
                    System.out.println("Enter your expenses: ");
                    // id, payer_id, amount, participants_ids, EQUAL/EXACT/PERCENT, values
                    String expenseId = sc.next();
                    String payerId = sc.next();
                    double amount = sc.nextDouble();
                    List<String> participants = new ArrayList<>();
                    int n = sc.nextInt();
                    int x = n;
                    while(x-- > 0){
                        String pId = sc.next();
                        participants.add(pId);
                    }   String type = sc.next();
                    List<Double> val = new ArrayList<>();
                    if(type.equals(SplitType.EXACT) || type.equals(SplitType.PERCENT)) {
                        while(n-- > 0){
                            Double v = sc.nextDouble();
                            val.add(v);
                        }
                    }   ExpenseRequestDTO ex = new ExpenseRequestDTO(expenseId, payerId, amount, null, null, val, new Date());
                    ledger.addExpense(ex);
                }
            }
        }
    }
}
