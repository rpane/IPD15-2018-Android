package com.example.roberto.panetta_roberto_final;

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable {

    private int accountNumber;
    private Date openDate;
    private double balance;

    public Account(int accountNumber, Date openDate, double balance) {
        this.accountNumber = accountNumber;
        this.openDate = openDate;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
