package com.brian;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    // Declare scanner as sc
    private static Scanner sc = new Scanner(System.in);

    // Prompt user to get a string, show error if value is empty
    public String getString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String str = sc.nextLine();
            if (!str.isEmpty()) {
                return str;
            } else {
                System.out.print("Error! This entry is required. Try again.\n");
            }
        }
    }

    // Prompt user to get an int between min and mix
    public int getInt(String prompt, int min, int max) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(prompt);
                int userGuess = sc.nextInt();
                if (userGuess >= min && userGuess <= max) {
                    return (userGuess - 1);
                } else {
                    System.out.println("Enter an amount between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                sc.next();
                System.out.println("Invalid input, please try again.");
            }
        }
    }
}