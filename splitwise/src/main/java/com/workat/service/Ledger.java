package com.workat.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.workat.entity.Expense;
import com.workat.entity.Pair;
import com.workat.entity.SplitType;
import com.workat.entity.User;

public class Ledger {
    Map<String, User> users = new HashMap<>();

    // (u1, u2, balance) -> u2 owns u1 amount of 'balance'
    Map<Pair, Double> balanceMap = new HashMap<>();

    public void addUser(User u){
        users.put(u.getId(), u);
    }

    public void addExpense(Expense e){
        User paying = e.getPayer();
        List<User> participants = e.getParticipants();
        double totalAmount = e.getAmount();

        for(int i = 0; i<participants.size(); i++){
            User participant = participants.get(i);

            double sharableAmout = getShare(totalAmount, e.getSplitType(), e.getValues().get(i));

            if(paying.getId().equals(participant.getId())){
                double newBal = participant.getBalance() + sharableAmout;
                participant.setBalance(newBal);
            } else{
                double newBal = participant.getBalance() - sharableAmout;
                participant.setBalance(newBal);
                Pair p = new Pair(paying, participant);
                double prevDue = balanceMap.get(p);
                balanceMap.put(p, prevDue + sharableAmout);
            }
        }
    }

    private double getShare(double totalAmount, SplitType splitType, Double val){
        return (double) (switch (splitType) {
            case EQUAL -> totalAmount/val;
            case EXACT -> val;
            default -> (double)(totalAmount * 100)/val;
        });
    }
}
