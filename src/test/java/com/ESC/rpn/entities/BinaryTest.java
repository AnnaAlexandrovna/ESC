package com.ESC.rpn.entities;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BinaryTest {

    @Test
    public void getBase() {
        Base bin = new Binary();
        Assert.assertEquals(2, bin.getBase());
    }

    @Test
    public void isNumber1() {
        Base bin = new Binary();
        Assert.assertEquals(true, bin.isNumber("1"));
    }

    @Test
    public void isNumber0() {
        Base bin = new Binary();
        Assert.assertEquals(true, bin.isNumber("0"));
    }
    @Test
    public void isNumber2() {
        Base bin = new Binary();
        Assert.assertEquals(false, bin.isNumber("2"));
    }

    @Test
    public void isNumberF() {
        Base bin = new Binary();
        Assert.assertEquals(false, bin.isNumber("F"));
    }


    @Test
    public void toDecimal() {
        Base bin = new Binary();
        Assert.assertEquals( new BigDecimal(232), new BigDecimal(bin.toDecimal("11101000")));
    }

    @Test
    public void toDecimal1() {
        Base bin = new Binary();
        Assert.assertEquals( new BigDecimal(2), new BigDecimal(bin.toDecimal("10")));
    }

    @Test
    public void fromDecimal() {
        Base bin = new Binary();
        Assert.assertEquals("11101000", bin.fromDecimal(232));
    }

    @Test
    public void fromDecimal1() {
        Base bin = new Binary();
        Assert.assertEquals("10", bin.fromDecimal(2));
    }
}