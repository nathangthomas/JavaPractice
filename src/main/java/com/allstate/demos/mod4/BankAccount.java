package com.allstate.demos.mod4;

public abstract class BankAccount {
    //members
    private int id;
    private String accountHolder;
    protected double balance;

    private static int nextId = 1;
    public static final double OVERDRAFT_LIMIT = -1000;

    public BankAccount(){
        this("anonymous");
    }

    public BankAccount(String accountHolder)
    {
        this.accountHolder=accountHolder;
    }

    public int hashCode(){
        return this.id;
    }

    public boolean equals(Object obj){
        BankAccount ba = (BankAccount) obj;
        boolean status = false;
        if(this.id==ba.id
                && this.accountHolder.equals(ba.accountHolder)
                && this.balance == ba.balance){
            status = true;
        }
        return status;
    }

    public int getId() {
        return  this.id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double deposit(double amount){
        this.balance +=amount;
        return balance;
    }

    public double deposit(double dollars, int cents){
        double amount = dollars + cents/100.0;
        return this.deposit(amount);
    }

    public double withDraw(double amount){
        this.balance -=amount;
        return balance;
    }

    public abstract String getTermsAndConditions();
    public abstract double getGuaranteedLimit();

    @Override
    public String toString() {
        String str = String.format("[%d] %s, %.2f", id, accountHolder, balance);
        return str;
    }

}