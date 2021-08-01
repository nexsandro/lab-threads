package com.jlabs.model;

public class Account {

    private int ammount = 0;

    public void deposit(int value) {
        this.ammount += value;
    }

    public int getAmmount() {
        return this.ammount;
    }

}
