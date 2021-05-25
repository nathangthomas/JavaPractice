package com.allstate.demos.mod9;

import com.allstate.demos.mod4.BankAccount;

public class AccountManager {
    public static void processAccounts(BankAccount ba) {
        ba.deposit(100);
        ba.withDraw(20);
        if (ba instanceof SavingsAccount) {
            ((SavingsAccount) ba).applyInterest();
        }
    }
}
