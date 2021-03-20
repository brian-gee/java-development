package com.brian;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    private static Scanner sc = new Scanner(System.in);

    public static String getString(String prompt) {
        // print out prompt and get user input as String s
        System.out.print(prompt);
        String s = sc.next();
        sc.nextLine();
        return s;
    }

    public static int getInt(String prompt) {
        while (true) {
            // declare variable outside of try/catch or it won't function properly
            int i;
            try {
                // prompt user for an integer userInt
                System.out.print(prompt);
                i = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                sc.next();      // discard invalid input
                System.out.println("Error! Invalid integer. Try again.");
                continue;
            }
            if (i <= 100 && i >= 0) {
                return i;
            } else {
                System.out.println("Error! Enter an integer between 0 - 100.");
            }
        }
    }

    public static String getString() {
        while (true) {
            // print out prompt and get user input as String cont
            System.out.print("\nContinue? (y/n): ");
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