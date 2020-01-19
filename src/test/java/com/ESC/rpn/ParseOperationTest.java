package com.ESC.rpn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParseOperationTest {

    @Test
    public void testParseOperation1() {
        RPNComputer rpnc = new RPNComputer();
        String remainder = rpnc.tryToParse("+3", 10, rpnc.operation, rpnc::isOperation);
        Assert.assertEquals("+", rpnc.operation.get(0));
        Assert.assertEquals("3", remainder);
    }

    @Test
    public void testParseOperation2() {
        RPNComputer rpnc = new RPNComputer();
        String remainder = rpnc.tryToParse("+187-2", 10, rpnc.operation, rpnc::isOperation);
        Assert.assertEquals("+", rpnc.operation.get(0));
        Assert.assertEquals("187-2", remainder);
    }

}
