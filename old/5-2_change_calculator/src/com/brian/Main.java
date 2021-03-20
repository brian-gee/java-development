package com.brian;

import java.util.Scanner;

public class Main {

    public static void changeCalc() {
        while (true) {
            // Declare scanner object and prompt user for number of cents
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter number of cents (0-99): ");
            int cents = sc.nextInt();

            // Declare value for each possible coin
            int quarters = cents/25;
            int dimes = (cents % 25) / 10;
            int nickels = ((cents % 25) % 10) / 5;
            int pennies = ((cents % 25) % 10) % 5;

            // Print out number of each coin necessary
            System.out.println("\nQuarters: " + quarters + "\n" +
                    "Dimes:    " + dimes + "\n" +
                    "Nickels:  " + nickels + "\n" +
                    "Pennies: " + pennies);

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
        System.out.println("Welcome to the Change Calculator\n");

        // Run changeCalc method
        changeCalc();
    }
}
