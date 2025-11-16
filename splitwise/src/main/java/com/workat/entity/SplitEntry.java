package com.workat.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SplitEntry {
    private final String userId;
    private final double share;
    private final SplitType splitType;
    private final double percentage;
}
