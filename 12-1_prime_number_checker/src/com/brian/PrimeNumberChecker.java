package com.brian;

import java.util.ArrayList;

public class PrimeNumberChecker {

    public static void numChecker() {
        Console c = new Console();
        String cont = "y";
        System.out.println("Prime Number Checker");
        while (cont.equals("y") || cont.equals("Y")) {
            int num = c.getInt("\nPlease enter an integer between 1 and 5000: ", 1, 5000);
            if (isPrime(num)) {
                System.out.println(num + " is a prime number.");
            } else {
                System.out.println(num + " is NOT a prime number.");
                printFactors(num);
            }
            cont = c.getContinueString("Try again? (y/n): ");
        }
        System.out.println("\nBye!");
    }



    private static boolean isPrime(int n) {
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;
        return true;
    }

    private static void printFactors(int num) {
        int factorNumber = 1;
        ArrayList<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= num; i++)
            if (num % i == 0) {
                factors.add(i);
            }
        System.out.print("It has " + factors.size() + " factors: ");
        for (Integer factor : factors) {
            System.out.print(factor + " ");
        }
        System.out.println();
    }
}