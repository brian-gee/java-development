package geertsma.account;

import geertsma.account.Account;

public class CheckingAccount extends Account {
    private double monthlyFee;

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }
}