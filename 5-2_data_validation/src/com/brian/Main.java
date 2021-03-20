package com.brian;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void tableOfPowers() {
        // declare scanner object
        Scanner sc = new Scanner(System.in);
        while (true) {
            // declare variable outside of try/catch or it won't function properly
            int userInt = 0;
            try
            {
                // prompt user for an integer userInt
                System.out.print("Enter an integer: ");
                userInt = sc.nextInt();
            }
            catch (InputMismatchException e)
            {
                sc.next();      // discard invalid input
                System.out.println("Invalid input, please try again.\n");
                continue;
            }

            // For loop that will print table of squares and cubes from 1 to userInt
            System.out.println("\nNumber  Squared Cubed");
            System.out.println("======  ======= =====");
            for (int i = 1; i <= userInt; i++) {
                System.out.printf("%d       %d       %d%n", i, (i*i), (i*i*i));
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
        System.out.println("Welcome to the Squares and Cubes table\n");

        // Run tableOfPowers method
        tableOfPowers();
    }
}