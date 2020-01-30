package com.ESC.rpn.entities;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class HexadecimalTest {

    @Test
    public void getBase() {
        Hexadecimal hexadecimal = new Hexadecimal();
        Assert.assertEquals(16, hexadecimal.getBase());
    }

    @Test
    public void isNumber() {
        Hexadecimal hexadecimal = new Hexadecimal();
        Assert.assertEquals(true, hexadecimal.isNumber("1"));
    }

    @Test
    public void isNumber1() {
        Hexadecimal hexadecimal = new Hexadecimal();
        Assert.assertEquals(true, hexadecimal.isNumber("0"));
    }

    @Test
    public void isNumberA() {
        Hexadecimal hexadecimal = new Hexadecimal();
        Assert.assertEquals(true, hexadecimal.isNumber("A"));
    }

    @Test
    public void isNumberF() {
        Hexadecimal hexadecimal = new Hexadecimal();
        Assert.assertEquals(true, hexadecimal.isNumber("F"));
    }

    @Test
    public void isNumbera() {
        Hexadecimal hexadecimal = new Hexadecimal();
        Assert.assertEquals(false, hexadecimal.isNumber("a"));
    }

    @Test
    public void toDecimal() {
        Hexadecimal hexadecimal = new Hexadecimal();
        Assert.assertEquals(new BigDecimal(54), new BigDecimal(hexadecimal.toDecimal("36")));
    }

    @Test
    public void toDecimal1() {
        Hexadecimal hexadecimal = new Hexadecimal();
        Assert.assertEquals(new BigDecimal(16702550), new BigDecimal(hexadecimal.toDecimal("fedc56")));
    }

    @Test
    public void fromDecimal() {
        Hexadecimal hexadecimal = new Hexadecimal();
        Assert.assertEquals( "fedc56", hexadecimal.fromDecimal(16702550));
    }
}