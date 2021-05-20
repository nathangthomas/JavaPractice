package com.allstate.labs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lab3Test {

    @Test
    void leapYearTest_shouldReturnTrue(){
        Lab3 lab3 = new Lab3();
        boolean methodCall = lab3.leapYear(1988);

        assertEquals(true, methodCall);
    }

    @Test
    void leapYearTest_shouldReturnFalse(){
        Lab3 lab3 = new Lab3();
        boolean methodCall = lab3.leapYear(1986);

        assertEquals(false, methodCall);
    }
}
