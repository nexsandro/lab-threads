package com.jlabs.model;

public class DepositEmployee extends Thread {

    private int valueToDeposit;

    private static final int MAX_DEPOSIT_ALLOWED = 10;

    private Account account;

    public DepositEmployee(Account account, int valueToDeposit) {
        this.account = account;
        this.valueToDeposit = valueToDeposit;
    }

    public void doDeposit() {
        int allowedValueToDeposit = MAX_DEPOSIT_ALLOWED;

        if (valueToDeposit < MAX_DEPOSIT_ALLOWED) {
            allowedValueToDeposit = valueToDeposit;
        }

        valueToDeposit -= allowedValueToDeposit;
        account.deposit(allowedValueToDeposit);
    }

    public void run() {

        while (valueToDeposit > 0) {
            doDeposit();
        }

        System.out.println(Thread.currentThread().getName() + " ended.");
    }

}
