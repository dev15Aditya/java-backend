package com.workat.dto;

import java.util.Date;
import java.util.List;

import com.workat.entity.SplitType;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ExpenseRequestDTO {
    private final String id;
    private final String payerId;
    private final double amount;
    private final List<String> participantIds;
    private final SplitType splitType;
    private final List<Double> values;
    private final Date createdAt;
}
