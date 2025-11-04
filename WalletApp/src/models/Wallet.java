package models;

public class Wallet {
    private double balance;

    public synchronized void deposit(double amount){
        if(amount <= 0) throw new IllegalArgumentException("Amount must be positive.");
        balance += amount;
    }

    public synchronized double getBalance(){
        return balance;
    }
}
