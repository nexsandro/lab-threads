package com.jlabs.model;

public class DepositAgency {

    private Account account;

    public DepositAgency(Account account) {
        this.account = account;
    }

    public void doDeposit(int workersQuantity, int totalValue) throws InterruptedException {

        int employeeValueToDeposit = totalValue / workersQuantity;
        final DepositEmployee workers[] = allocateEmployees(workersQuantity, account, employeeValueToDeposit);

        for (DepositEmployee employee: workers) {
            employee.start();
        }

        for (DepositEmployee employee: workers) {
            employee.join();
        }

        System.out.println("Final ammount ...........: " + account.getAmmount());
        System.out.println("Expected final ammount ..: " + employeeValueToDeposit * workersQuantity);
    }

    private DepositEmployee[] allocateEmployees(int quantity, Account account, int valueToDeposit) {
        final DepositEmployee workers[] = new DepositEmployee[quantity];
        for(int i=0; i<quantity; i++) {
            workers[i] = getWorker( this.account, valueToDeposit);
        }
        return workers;
    }

    private DepositEmployee getWorker(Account account, int valueToDeposit) {
        return new DepositEmployee(account, valueToDeposit);
    }

}
