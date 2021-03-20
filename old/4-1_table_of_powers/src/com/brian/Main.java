package com.brian;

import java.util.Scanner;

public class Main {

    public static void tableOfPowers() {
        while (true) {
            // Declare scanner object and print out prompt for an integer
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter an integer: ");
            int userInt = sc.nextInt();

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
