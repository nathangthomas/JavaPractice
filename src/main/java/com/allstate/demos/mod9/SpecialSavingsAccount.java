package com.allstate.demos.mod9;

public final class  SpecialSavingsAccount extends SavingsAccount{

    public SpecialSavingsAccount(String accountHolder, boolean premium) {
        super(accountHolder, premium);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    private double bonus;
    public void applyBonus(double bonus) {
        balance +=bonus;
    }

}