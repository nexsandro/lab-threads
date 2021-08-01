package com.jlabs;

import com.jlabs.model.Account;
import com.jlabs.model.DepositAgency;
import com.jlabs.model.SafeAccount;

public class SafeMain {

    public static final int TOTAL_VALUE_TO_DEPOSIT = 100_000;
    public static final int WORKERS_QUANTITY = 10;

    public static void main(String[] args) throws InterruptedException {
        Account account = new SafeAccount();
        new DepositAgency(account).doDeposit( WORKERS_QUANTITY, TOTAL_VALUE_TO_DEPOSIT);
    }

}
