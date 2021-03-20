package com.brian;

import java.util.Scanner;

public class Main {

    public static void greatestCommonDivisor() {
        while (true) {
            // Declare scanner object and prompt user for 2 numbers
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter first number: ");
            int num1 = sc.nextInt();
            System.out.print("Enter second number: ");
            int num2 = sc.nextInt();

            // Loop with nested loop to calculate GCD of two provided numbers
            while (num1 != num2) {
                if (num1 > num2)
                    num1 = num1 - num2;
                else
                    num2 = num2 - num1;
            }

            // Print out GCD for the two entered numbers
            System.out.println("Greatest common divisor: " + num2);


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
        System.out.println("Greatest Common Divisor Finder\n");

        // Run greatestCommonDivisor method
        greatestCommonDivisor();
    }
}
