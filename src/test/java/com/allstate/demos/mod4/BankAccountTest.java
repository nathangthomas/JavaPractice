package com.allstate.demos.mod4;

import com.allstate.demos.mod9.SavingsAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BankAccountTest {
    SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    Date dtval1;
    Date dtval2;

    BankAccount bankAccount;
    @BeforeEach
    void setUp() {
        try {
            Date dtval1 = dt.parse("20-05-2021 19:12:22");
            Date dtval2 = dt.parse("20-05-2021 19:12:22");
        } catch (
                ParseException e) {
            e.printStackTrace();
        }

        bankAccount = new SavingsAccount();
        bankAccount.setId(100);
    }


    @Test
    void dateTest(){
        assertEquals (dtval2, dtval1);
    }

    @Test
    void idTest(){
        assertEquals (100, bankAccount.getId());
    }

    @Test
    void depositTest(){
        bankAccount.deposit(1000);
        assertEquals (1000, bankAccount.getBalance());
    }
    @Test
    void withDrawTest(){
        bankAccount.deposit(2000);
        bankAccount.withDraw(1000);
        assertEquals (1000, bankAccount.getBalance());
    }


    @Test
    void depositDollarsTest(){
        bankAccount.deposit(1000, 2400);
        assertEquals (1024, bankAccount.getBalance());
    }

    @Test
    void toStringTest(){
        bankAccount.deposit(1000, 2400);
        bankAccount.setAccountHolder("dee");
        assertEquals ("[100] dee, 1024.00", bankAccount.toString());
    }

    @Test
    void constructorTest(){

        assertEquals ("anonymous", bankAccount.getAccountHolder());
    }

    @Test
    void classMemberTest(){

        assertEquals (-1000, BankAccount.OVERDRAFT_LIMIT);
    }
}
