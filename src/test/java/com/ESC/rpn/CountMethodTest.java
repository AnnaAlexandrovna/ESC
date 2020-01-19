package com.ESC.rpn;

import org.junit.Assert;
import org.junit.Test;

public class CountMethodTest {

    @Test
    public void testCount1(){
        RPNComputer rpnc = new RPNComputer();
        rpnc.parse("2+3", 10);
        Assert.assertEquals("5", rpnc.count());
        Assert.assertEquals("5", rpnc.lexem.get(0));
    }

    @Test
    public void testCount2(){
        RPNComputer rpnc = new RPNComputer();
        rpnc.parse("12-25", 10);
        Assert.assertEquals("-13", rpnc.count());
        Assert.assertEquals("-13", rpnc.lexem.get(0));
    }
}
