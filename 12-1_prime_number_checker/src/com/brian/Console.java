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
            } else {
                System.out.print("Error! This entry is required. Try again.\n");
            }
        }
    }


    public String getContinueString(String prompt) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("\n" + prompt);
            String cont = sc.nextLine();

            if (cont.equals("y") || cont.equals("n") || cont.equals("Y") || cont.equals("N")) {
                return cont;
            } else
            if (cont.isEmpty()) {
                System.out.print("Error! This entry is required. Try again.");
            } else System.out.print("Error! Entry Must be 'y' or 'n'. Try again.");
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