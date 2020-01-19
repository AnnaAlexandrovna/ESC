package com.ESC.rpn.entities;

public interface Base {

    public int getBase();

    public Boolean isNumber(String firstSymbol);
    public Integer toDecimal(String number);
    public String fromDecimal(Integer number);
}
