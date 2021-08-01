package com.jlabs.model;

public class SafeAccount extends Account{

    @Override
    public synchronized void deposit(int value) {
        super.deposit(value);
    }
}
