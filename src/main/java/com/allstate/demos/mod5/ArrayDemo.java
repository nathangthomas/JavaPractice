package com.allstate.demos.mod5;

import com.allstate.demos.mod4.BankAccount;
import com.allstate.demos.mod9.CurrentAccount;
import com.allstate.demos.mod9.SavingsAccount;

import java.util.Arrays;

public class ArrayDemo {

    public static int[] demo1SimpleArray()
    {
        int[] nums= new int[5];
        nums[0]=12;
        nums[1]=14;
        nums[2]=16;
        nums[3]=17;
        nums[4]=12;

        return nums;
    }

    public static BankAccount[] demo2ArrayofObjects()
    {
        BankAccount[] accounts= new BankAccount[3];
        accounts[0]= new SavingsAccount("Deirdre", false);
        accounts[1]= new SavingsAccount("Ann", false);
        accounts[2]= new CurrentAccount();

        return accounts;
    }

    public static int[] demo3SimpleArray()
    {
        int[] nums= new int[5];
        Arrays.fill( nums,1);

        Arrays.fill( nums,2,5, 6);

        return nums;
    }

}
