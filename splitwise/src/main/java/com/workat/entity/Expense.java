package com.workat.entity;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Expense {
    private final String id;
    private final User payer;
    private final double amount;
    private final List<User> participants;
    private final SplitType splitType;
    private final List<Double> values;
    private final Date createdAt;
}
