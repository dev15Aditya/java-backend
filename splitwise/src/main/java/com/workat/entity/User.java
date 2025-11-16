package com.workat.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class User {
    private final String id;
    private final String name;

    double balance = 0.0;
}
