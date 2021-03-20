package com.brian;

import java.util.Scanner;

public class Main {

    public static void factorialCalc() {
        while (true) {
            // Declare scanner object and prompt user for an integer
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter an integer that's greater than 0 and less than 16: ");
            int userInt = sc.nextInt();

            // Declare placeholder for factorial
            int factorial = 1;

            // Loop to calculate factorial of userInt and print the value
            for (int i = 1; i <= userInt; i++) {
                factorial = factorial * i;
            }
            System.out.println("The factorial of " + userInt + " is " + factorial + ".");

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
        System.out.println("Welcome to the Factorial Calculator\n");

        // Run factorialCalc method
        factorialCalc();


    }
}
