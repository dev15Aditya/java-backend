package com.workat.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.workat.dto.ExpenseRequestDTO;
import com.workat.entity.Pair;
import com.workat.entity.SplitType;
import com.workat.entity.User;

public class Ledger {
    Map<String, User> users = new HashMap<>();

    // (u1, u2, balance) -> u2 owns u1 amount of 'balance'
    Map<Pair, Double> balanceMap = new HashMap<>();
    DummyUsers du = new DummyUsers(2);

    public Ledger() {
        users = du.createUsers();
    }

    
    public void addUser(User u){
        users.put(u.getId(), u);
    }

    public void addExpense(ExpenseRequestDTO e){
        User paying = users.get(e.getPayerId());
        List<User> participants = new ArrayList<>();
        for(String pId: e.getParticipantIds()){
            participants.add(users.get(pId));
        }

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

    public void show(){
        boolean flag = balanceMap.isEmpty();

        if(flag){
            System.out.println("No balances");
        } else{
            for(Map.Entry<Pair, Double> balance: balanceMap.entrySet()){
                double due = balance.getValue();
                if(due == 0) continue;
    
                System.out.println(balance.getKey().getU2() + " owes " + balance.getKey().getU1() + ": " + balance.getValue());
            }
        }
    }

    public void showOne(String id){
        boolean flag = balanceMap.isEmpty();

        if(flag){
            System.out.println("No balances");
        } else{
            for(Map.Entry<Pair, Double> balance: balanceMap.entrySet()){
                double due = balance.getValue();
                if(due == 0) continue;

                if(balance.getKey().getU1().getId().equals(id) || balance.getKey().getU2().getId().equals(id)){
                    System.out.println(balance.getKey().getU2() + " owes " + balance.getKey().getU1() + ": " + balance.getValue());
                }
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
