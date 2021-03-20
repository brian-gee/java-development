package geertsma.account;

import geertsma.account.Account;

public class SavingsAccount extends Account {
    private double monthlyInterestRate = 1;
    private double monthyInterestPayment = 12;

    public double getMonthlyInterestRate() {
        return monthlyInterestRate;
    }

    public void setMonthlyInterestRate(double monthlyInterestRate) {
        this.monthlyInterestRate = monthlyInterestRate;
    }

    public double getMonthyInterestPayment() {
        return monthyInterestPayment;
    }

    public void setMonthyInterestPayment(double monthyInterestPayment) {
        this.monthyInterestPayment = monthyInterestPayment;
    }
}