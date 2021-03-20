package com.brian;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void tipCalculator() {
        while (true) {
            // Declare scanner object and prompt user for cost of meal
            Scanner sc = new Scanner(System.in);
            System.out.print("Cost of meal: ");
            BigDecimal mealCost= sc.nextBigDecimal();
            System.out.println();

            // Declare percent number format
            NumberFormat nfPercent = NumberFormat.getPercentInstance();

            // For loop to calculate tip and total for 15, 20, and 25 percent tip
            for (double i = 0.15; i <= 0.25; i = i + 0.05){
                BigDecimal tip = mealCost.multiply(BigDecimal.valueOf(i));
                BigDecimal totalCost = mealCost.add(tip);
                String tipPercent = nfPercent.format(i);
                System.out.println((tipPercent) + "\n" +
                        "Tip amount:    $" + tip.setScale(2, RoundingMode.HALF_UP) + "\n" +
                        "Total amount:  $" + totalCost.setScale(2, RoundingMode.HALF_UP) + "\n");
            }

            // Print continue prompt and break if user doesn't enter y
            System.out.print("\nContinue? (y/n): ");
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
        System.out.println("Tip Calculator\n");

        // Run tipCalculator method
        tipCalculator();


    }
}
