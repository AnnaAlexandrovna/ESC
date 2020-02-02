package com.ESC.rpn;

import org.junit.Assert;
import org.junit.Test;

public class CountMethodTest {

    // тут мы проверяет простое сложение двух аргументов
    @Test
    public void testCount1(){
        RPNComputer rpnc = new RPNComputer();
        rpnc.parse("2+3", 10);
        Assert.assertEquals("5", rpnc.count(10));
    }

    @Test
    public void testCount2(){
        RPNComputer rpnc = new RPNComputer();
        rpnc.parse("12-25", 10);
        Assert.assertEquals("-13", rpnc.count(10));
    }

    @Test
    public void testCount3(){
        RPNComputer rpnc = new RPNComputer();
        rpnc.parse("2*3", 10);
        Assert.assertEquals("6", rpnc.count(10));
    }

    @Test
    public void testCount4(){
        RPNComputer rpnc = new RPNComputer();
        rpnc.parse("12/3", 10);
        Assert.assertEquals("4", rpnc.count(10));
    }

    @Test
    public void testHex(){
        RPNComputer rpnc = new RPNComputer();
        rpnc.parse("A+A", 16);
        Assert.assertEquals("14", rpnc.count(16));
    }

    //деление на ноль, скобки, больше двух аргументов, унарные операции, вложенные скобки, вызов функции в функции
    //границы инта

}
