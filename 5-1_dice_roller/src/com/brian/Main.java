package com.brian;

import java.util.Scanner;

public class Main {

    public static void diceRoller() {
        while (true) {
            // Declare two random numbers each time the loop runs
            int die1 =  (int) (Math.random() * 6) + 1;
            int die2 =  (int) (Math.random() * 6) + 1;
            int total = die1 + die2;


            // Print out result of each die and their total
            System.out.println("Die 1: " + die1);
            System.out.println("Die 2: " + die2);
            System.out.println("Total: " + total);

            // if statement to print out when user rolls snake eyes and boxcar
            if (die1 == 1 && die2 == 1) {
                System.out.println("Snake eyes!");
            }
            else if (die1 == 6 && die2 == 6) {
                System.out.println("Boxcars!");
            }


            // Print continue prompt and break if user doesn't enter y
            Scanner sc = new Scanner(System.in);
            System.out.print("\nRoll again? (y/n): ");
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
        System.out.println("Dice Roller\n");

        // Run diceRoller method
        diceRoller();
    }
}