package com.brian;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    private static Scanner sc = new Scanner(System.in);

    public String getString(String prompt) {
        System.out.print(prompt);
        String s = sc.next();
        sc.nextLine();
        return s;
    }

    public int getInt(String prompt, int min) {
        while (true) {
            int i;
            try {
                System.out.print(prompt);
                i = sc.nextInt();
                if (i >= min) {
                    return i;
                } else
                    System.out.println("Error! Invalid integer. Try again.");
            } catch (InputMismatchException e) {
                sc.next();
                System.out.println("Error! Invalid integer. Try again.");
            }
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

    public double getDouble(String prompt, int min) {
        while (true) {
            double i;
            try {
                System.out.print(prompt);
                i = sc.nextDouble();
                if (i >= min) {
                    return i;
                } else {
                    System.out.println("Error! Invalid integer. Try again.");}
            } catch (InputMismatchException e) {
                sc.next();
                System.out.println("Error! Invalid integer. Try again.");

            }
        }
    }

    public double getDouble(String prompt, int min, int max) {
        while (true) {
            double i;
            try {
                System.out.print(prompt);
                i = sc.nextDouble();
                if (i >= min && i <= max) {
                    return i;
                } else {
                    System.out.println("Error! Invalid integer. Try again.");}
            } catch (InputMismatchException e) {
                sc.next();
                System.out.println("Error! Invalid integer. Try again.");
            }
        }
    }

    public String getContinueString() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("\nPlay again? (y/n): ");
            String cont = sc.nextLine();
            if (cont.equals("y") || cont.equals("n") || cont.equals("Y") || cont.equals("N")) {
                return cont;
            } else
                if (cont.isEmpty()) {
                    System.out.print("Error! This entry is required. Try again.");
                } else System.out.print("Error! Entry Must be 'y' or 'n'. Try again.");
        }
    }

    public String getBL(String prompt) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(prompt);
            String bl = sc.nextLine();
            if (bl.equals("b") || bl.equals("l")) {
                return bl;
            } else {
                if (bl.isEmpty()) { // show error if entry is blank
                    System.out.print("Error! This entry is required. Try again.\n");
                } else System.out.print("Error! Entry Must be 'b' / 'l'. Try again.\n");
            }
        }
    }

    public String getRPS(String prompt) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String rps = sc.nextLine();

            if (rps.equals("r") || rps.equals("p") || rps.equals("s")){
                return rps;
            } else {
                if (rps.isEmpty()) {
                    System.out.print("Error! This entry is required. Try again.\n");
                } else System.out.print("Error! Entry Must be 'r' / 'p' / 's'. Try again.\n");
            }
        }
    }
}