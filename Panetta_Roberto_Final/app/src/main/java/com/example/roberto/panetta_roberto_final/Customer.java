package com.example.roberto.panetta_roberto_final;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {

    private Account account;
    private String name;
    private String family;
    private String phoneNo;
    private int SIN;

    public Customer(Account account, String name, String family, String phoneNo, int SIN) {
        this.account = account;
        this.name = name;
        this.family = family;
        this.phoneNo = phoneNo;
        this.SIN = SIN;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getSIN() {
        return SIN;
    }

    public void setSIN(int SIN) {
        this.SIN = SIN;
    }


    @Override
    public String toString() {
        return getName()+" "+getFamily();
    }
}