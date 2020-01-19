package com.ESC.rpn;


import org.junit.Assert;
import org.junit.Test;

public class ExpressionEvaluationTest {

    @Test
    public void test1 (){
        String s = "2+3";
        RPNComputer test1 = new RPNComputer();
        test1.madeTwoArray(s);

        Assert.assertEquals(test1.count(), "5");
    }

    @Test
    public void test2 (){
        String s = "20+3";
        RPNComputer test1 = new RPNComputer();
        test1.madeTwoArray(s);

        Assert.assertEquals(test1.count(), "23");
    }

}
