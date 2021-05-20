package com.allstate.labs;


public class Lab3 {

    public boolean leapYear(int year) {

        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ?
                true : false;
        System.out.println(isLeapYear);
        return isLeapYear;
    }

}
