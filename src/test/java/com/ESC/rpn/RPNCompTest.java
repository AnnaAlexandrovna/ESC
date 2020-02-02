package com.ESC.rpn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RPNCompTest {

    @Test
    public void parse() {

    }

    @Test
    public void tryToParseNumber() {
        RPNComp rpnComp = new RPNComp();
        rpnComp.tryToParseNumber("1234");
        Assert.assertEquals("1234", rpnComp.lexem.get(0));
    }

    @Test
    public void tryToParseOperation() {
    }

    @Test
    public void isOperation() {
    }

    @Test
    public void count() {
    }
}