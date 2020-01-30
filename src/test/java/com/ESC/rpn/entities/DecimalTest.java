package com.ESC.rpn.entities;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DecimalTest {
    @Test
    public void getBase() {
        Decimal decimal = new Decimal();
        Assert.assertEquals(10, decimal.getBase());
    }

    @Test
    public void isNumber() {
        Decimal decimal = new Decimal();
        Assert.assertEquals(true, decimal.isNumber("1"));
    }

    @Test
    public void isNumber1() {
        Decimal decimal = new Decimal();
        Assert.assertEquals(true, decimal.isNumber("0"));
    }

    @Test
    public void isNumberA() {
        Decimal decimal = new Decimal();
        Assert.assertEquals(false, decimal.isNumber("A"));
    }

    @Test
    public void isNumbera() {
        Decimal decimal = new Decimal();
        Assert.assertEquals(false, decimal.isNumber("a"));
    }

    @Test
    public void toDecimal() {
        Decimal decimal = new Decimal();
        Assert.assertEquals(new BigDecimal(36), new BigDecimal(decimal.toDecimal("36")));
    }

    @Test
    public void toDecimal1() {
        Decimal decimal = new Decimal();
        Assert.assertEquals(new BigDecimal(0), new BigDecimal(decimal.toDecimal("0")));
    }

    @Test
    public void fromDecimal() {
        Decimal decimal = new Decimal();
        Assert.assertEquals( "16702550", decimal.fromDecimal(16702550));
    }

}