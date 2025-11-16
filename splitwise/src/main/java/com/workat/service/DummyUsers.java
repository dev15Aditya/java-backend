package com.workat.service;

import java.util.HashMap;
import java.util.Map;

import com.workat.entity.User;

public class DummyUsers {
    private final int n;

    public DummyUsers(int users) {
        this.n = users;
    }

    public Map<String, User> createUsers(){
        Map<String, User> users = new HashMap<>();

        for(int i = 1; i<=n; i++){
            String uId = "u" + i;
            User user = new User(uId, "User"+i, 0);
            users.put(uId, user);
        }

        return users;
    }
    
}
