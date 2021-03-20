package geertsma.app;

import geertsma.account.CheckingAccount;
import geertsma.account.SavingsAccount;
import geertsma.presentation.Console;

import java.text.NumberFormat;
import java.util.Locale;

public class AccountBalanceApp {
    // Declare checking and saving objects
    CheckingAccount ca = new CheckingAccount();
    SavingsAccount sa = new SavingsAccount();
    Console c = new Console();
    String userChoice;

    public void accountBalanceApp() {
        System.out.println("Welcome to the Account application\n");
        String cont = "y";
        start();
        while (cont.equals("y") || (cont.equals("Y"))) {
            userChoice = c.getWD("Withdrawal or deposit? (w/d): ");
            if (userChoice.equals("w")) {
                withdraw();
            } else if (userChoice.equals("d")) {
                deposit();
            }
            cont = c.getContinueString();
        }
        finish();
    }

    private void start() {
        ca.setMonthlyFee(1);
        sa.setMonthlyInterestRate(1);
        sa.setMonthyInterestPayment(12);
        ca.setBalance(1000);
        sa.setBalance(1000);
        System.out.println("Starting Balances");
        System.out.println("Checking: " + formatCurrency(ca.getBalance()));
        System.out.println("Savings:  " + formatCurrency(sa.getBalance()) + "\n");
        System.out.println("Enter the transactions for the month\n");
    }

    private void finish() {
        ca.withdraw(ca.getMonthlyFee());
        sa.deposit(sa.getMonthyInterestPayment());
        System.out.println("\nMonthly Payments and Fees");
        System.out.println("Checking fee:              " + formatCurrency(ca.getMonthlyFee()));
        System.out.println("Savings interest payment:  " + formatCurrency(sa.getMonthyInterestPayment()));
        System.out.println("Final Balances\n");
        System.out.println("Checking: " + formatCurrency(ca.getBalance()));
        System.out.println("Savings:  " + formatCurrency(sa.getBalance()) + "\n");
    }

    private void withdraw() {
        userChoice = c.getCS("Checking or savings? (c/s): ");
        double amount = c.getDouble("Amount?: ", 0);
        if (userChoice.equals("c")) {
            ca.withdraw(amount);
        } else if (userChoice.equals("s")) {
            sa.withdraw(amount);
        }
    }

    private void deposit() {
        userChoice = c.getCS("Checking or savings? (c/s): ");
        double amount = c.getDouble("Amount?: ", 0);
        if (userChoice.equals("c")) {
            ca.deposit(amount);
        } else if (userChoice.equals("s")) {
            sa.deposit(amount);
        }
    }

    private String formatCurrency(double amount) {
        return NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(amount);
    }
}