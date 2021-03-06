package com.brian;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    private static Scanner sc = new Scanner(System.in);

    public String getString(String prompt) {
        // print out prompt and get user input as String s
        System.out.print(prompt);
        String s = sc.next();
        sc.nextLine();
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
                    System.out.println("Enter an amount between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) { // catch input that isn't type int
                sc.next();      // discard invalid input
                System.out.println("Invalid input, please try again.");
            }
        }
    }

    public double getDouble(String prompt, int min, int max) {
        while (true) {
            // declare variable outside of try/catch or it won't function properly
            double i;
            try {
                // prompt user for an integer userInt
                System.out.print(prompt);
                i = sc.nextDouble();
                if (i >= min && i <= max) {
                    return i;
                } else
                    // remind user to enter between 1 - 100
                    System.out.println("Error! Invalid integer. Try again.");
            } catch (InputMismatchException e) { // catch input that isn't type int
                sc.next();
                System.out.println("Error! Invalid integer. Try again.");
            }
        }
    }

    public String getContinueString(String prompt) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            // print out prompt and get user input as String cont
            System.out.print("\n" + prompt);
            String cont = sc.nextLine();

            // if/else that only accepts y/n Y/N and will not allow an empty entry
            if (cont.equals("y") || cont.equals("n") || cont.equals("Y") || cont.equals("N")) {
                return cont;
            } else // show error if users enters anything other than y/Y or n/N
                if (cont.isEmpty()) { // show error if entry is blank
                    System.out.print("Error! This entry is required. Try again.");
                } else System.out.print("Error! Entry Must be 'y' or 'n'. Try again.");
        }
    }

}
