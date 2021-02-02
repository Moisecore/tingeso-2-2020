package com.tingeso.webapp.model;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class CalcTest {

    @Test
    public void getNum1Test(){
        Calc calc = new Calc(1,2,"+","3");
        double num1 = calc.getNum1();
        assertEquals(11, num1,0);
    }

    @Test
    public void getNum2Test(){
        Calc calc = new Calc(1,2,"+","3");
        double num2 = calc.getNum2();
        assertEquals(2, num2,0);
    }

    @Test
    public void getOperTest(){
        Calc calc = new Calc(1,2,"+","3");
        String oper = calc.getOper();
        assertEquals("+", oper);
    }

    @Test
    public void getResTest(){
        Calc calc = new Calc(1,2,"+","3");
        String res = calc.getRes();
        assertEquals("3", res);
    }

}
