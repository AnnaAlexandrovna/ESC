package com.ESC.rpn.entities;

public class Binary implements Base  {
    @Override
    public int getBase() {
        return 2;
    }

    @Override
    public Boolean isNumber(String firstSymbol) {
        return (firstSymbol.equals("0")||firstSymbol.equals("1"));
    }

    @Override
    public Integer toDecimal(String number) {
        return Integer.parseInt(number, 2);
    }

    @Override
    public String fromDecimal(Integer number) {

        return Integer.toBinaryString(number);
    }
}
