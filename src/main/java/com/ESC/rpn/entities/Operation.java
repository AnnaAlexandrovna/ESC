package com.ESC.rpn.entities;

import java.util.function.BiFunction;

public class Operation {
    private String value;
    private Boolean isUnary;
    private BiFunction<Integer, Integer, Integer> calculate;

    public Operation(String value, Boolean isUnary, BiFunction<Integer, Integer, Integer> calculate) {
        this.value = value;
        this.isUnary = isUnary;
        this.calculate = calculate;
    }

    public BiFunction<Integer, Integer, Integer> getCalculate() {
        return calculate;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getUnary() {
        return isUnary;
    }

    public void setUnary(Boolean unary) {
        isUnary = unary;
    }
}
