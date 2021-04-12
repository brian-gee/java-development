package com.brian;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    private static Scanner sc = new Scanner(System.in);

    public String getString(String prompt) {
        // print out prompt and get user input as String s
        System.out.print(prompt);
        String s = sc.nextLine();
        return s;
    }

    public int getInt(String prompt, int min, int max) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(prompt);
                int userGuess = sc.nextInt();
                // if/else to make sure input is between 1 - 100
                if (userGuess >= min && userGuess <= max) {
                    return userGuess;
                } else {
                    // remind user to enter between 1 - 100
                    System.out.println("Enter a number between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) { // catch input that isn't type int
                sc.next();      // discard invalid input
                System.out.println("Invalid input, please try again.");
            }
        }
    }
}