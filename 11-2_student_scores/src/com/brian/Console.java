package com.brian;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    private static Scanner sc = new Scanner(System.in);

    public String getString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String str = sc.nextLine();
            if (!str.isEmpty()) {
                return str;
            } else if (str.isEmpty()) {
                System.out.print("Error! This entry is required. Try again.\n");
            } else System.out.print("Invalid input, please try again.");
        }
    }


    public int getInt(String prompt, int min, int max) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(prompt);
                int userGuess = sc.nextInt();
                if (userGuess >= min && userGuess <= max) {
                    return userGuess;
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