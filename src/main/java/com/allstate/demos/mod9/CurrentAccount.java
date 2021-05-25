package com.allstate.demos.mod9;

import com.allstate.demos.mod4.BankAccount;

public class CurrentAccount extends BankAccount {

    // Define additional class data.
    private static final double GUARANTEED_LIMIT = 30000;	// The first £30,000 of the balance in guaranteed.

    // Implementation of abstract members from superclass.
    public String getTermsAndConditions() {
        return "Current Accounts do not accrue interest. " +
                "Account holders can request a cheque book, and they can say how many cheques they're likely to need. " +
                "Current Accounts are guaranteed by law for the first £" + GUARANTEED_LIMIT;
    }

    @Override
    public double getGuaranteedLimit() {
        return 0;
    }

}
