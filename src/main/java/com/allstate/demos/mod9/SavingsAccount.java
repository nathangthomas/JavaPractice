package com.allstate.demos.mod9;

import com.allstate.demos.mod4.BankAccount;

public class SavingsAccount extends BankAccount {
    // Define additional instance data.
    private boolean premium;

    public boolean isGoneOverdrawn() {
        return goneOverdrawn;
    }

    public SavingsAccount(){

    }

    private boolean goneOverdrawn;

    // Constructors.
    public SavingsAccount(String accountHolder, boolean premium) {
        super(accountHolder);
        this.premium = premium;
    }
    // Define additional class data.
    private static final double BASIC_INTEREST_RATE   = 0.015;	// Represents 1.5%
    private static final double PREMIUM_INTEREST_RATE = 0.030;	// Represents 3.0%
    private static final double GUARANTEED_LIMIT      = 50000;	// The first £50,000 of the balance in guaranteed.

    // Additional methods.
    public void applyInterest() {
        if (balance < 0) {
            // Sorry mate, no interest if you're overdrawn.
        }
        else if (premium && !goneOverdrawn) {
            balance *= (1 + PREMIUM_INTEREST_RATE);
        }
        else {
            balance *= (1 + BASIC_INTEREST_RATE);
        }
        goneOverdrawn = false;
    }

    @Override
    public double withDraw(double amount) {
        super.withDraw(amount);
        if (balance < 0) {
            goneOverdrawn = true;
        }
        return balance;
    }

    @Override
    public String getTermsAndConditions() {
        return "Under review";
    }

    @Override
    public double getGuaranteedLimit() {
        return 0;
    }

}
