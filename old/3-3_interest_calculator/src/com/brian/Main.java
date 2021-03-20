package com.brian;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void interestCalc() {
        while (true) {
            // Declare scanner object and print out prompts for loan amount and interest rate
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter loan amount:   ");
            BigDecimal loan = sc.nextBigDecimal();
            System.out.print("Enter interest rate: ");
            BigDecimal interest = sc.nextBigDecimal();

            // Declare NumberFormat for US dollar and format loan
            NumberFormat nfDollar = NumberFormat.getCurrencyInstance(Locale.US);
            String loanAmount = nfDollar.format(loan);

            // Calculate and format interestRate and totalInterest
            BigDecimal interestRate = interest.multiply(BigDecimal.valueOf(100));
            interestRate = interestRate.setScale(3, RoundingMode.HALF_UP);
            BigDecimal totalInterest = loan.multiply(interest);
            String totalInterestFormatted = nfDollar.format(totalInterest);

            // Print out loan amount, interest rate, and total interest formatted
            System.out.println("\nLoan amount:         " + loanAmount);
            System.out.println("Interest rate:       " + interestRate+ "%");
            System.out.println("Interest:            " + totalInterestFormatted + "\n");

            // Print continue prompt and break if user doesn't enter y
            System.out.print("Continue? (y/n): ");
            String cont = sc.next();
            if (cont.equals("y") || (cont.equals("Y"))) {
            } else {
                break;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Print program title and blank line
        System.out.println("Welcome to the Interest Calculator\n");

        // Run interestCalc method
        interestCalc();
    }
}
