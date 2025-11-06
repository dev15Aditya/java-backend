package service;

import java.util.HashMap;
import java.util.Map;
import models.User;

public class WalletService {
    private final Map<String, User> users = new HashMap<>();

    public User createUser(String id, String name){
        if(users.containsKey(id)) {
            throw new IllegalArgumentException("User already exists");
        }

        User user = new User(id, name);
        users.put(id, user);
        return user;
    }

    public void deposit(String userId, double amount){
        User user = getUser(userId);
        user.getWallet().deposit(amount);
    }

    public double getBalance(String userId){
        return getUser(userId).getWallet().getBalance();
    }


    public User getUser(String userId){
        if(!users.containsKey(userId)){
            throw new IllegalArgumentException("User not found.");
        }
        return users.get(userId);
    }
}
