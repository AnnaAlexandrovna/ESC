package com.ESC.rpn.entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hexadecimal implements Base {
    @Override
    public int getBase() {
        return 16;
    }

    @Override
    public Boolean isNumber(String firstSymbol) {
        Matcher matcher = Pattern.compile("[A-F0-9]").matcher(firstSymbol);
        return matcher.matches();
    }

    @Override
    public Integer toDecimal(String number) {
        return Integer.parseInt(number, 16);
    }

    @Override
    public String fromDecimal(Integer number) {
        return Integer.toHexString(number);
    }
}
