package com.workat.service;

import java.util.List;

public class Validators {

    public Validators() {
    }
    
    public void validatePercentage(List<Double> values){
        double sum = 0;
        for(double d: values){
            sum += d;
        }

        if(sum != 100.0){
            throw new IllegalArgumentException("Enter valid percentages!");
        }
    }

    public void validateExactAmount(List<Double> values, double total){
        double sum = 0;
        for(double d: values){
            sum += d;
        }

        if(sum != total){
            throw new IllegalArgumentException("Exact value sum must be equal to total!");
        }
    }
}
