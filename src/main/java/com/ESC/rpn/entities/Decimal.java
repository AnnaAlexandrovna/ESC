package com.ESC.rpn.entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Decimal implements Base {


    @Override
    public int getBase() {
        return 10;
    }

    @Override
    public Boolean isNumber(String firstSymbol) {
        Matcher matcher = Pattern.compile("\\d").matcher(firstSymbol);
        return matcher.matches();
    }

    @Override
    public Integer toDecimal(String number) {
        return Integer.parseInt(number);
    }

    @Override
    public String fromDecimal(Integer number) {
        return number.toString();
    }
}
