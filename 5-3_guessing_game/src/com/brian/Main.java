package com.brian;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);     // declare scanner to be used in any method

    public static void main(String[] args) {
        // welcome message for the program
        System.out.println("Welcome to the Guess the Number Game");
        System.out.println("++++++++++++++++++++++++++++++++++++");

        while (true) {   // main loop to run guessingGame method
            guessingGame();

            String cont = getContinueChar();
            if (cont.equals("y") || (cont.equals("Y"))) {   // continue if user enters y or Y
            } else if (cont.equals("n") || (cont.equals("N"))) {    // break if user enters n or N
                System.out.println("\nBye - Come back soon!");
                break; // quit program is user enters n/N
            } else {
                getContinueChar(); // otherwise prompt again if entry is not y/Y
            }
        }
    }

    public static void guessingGame() {
        int tries = 0;  // variable to keep track of users guesses
        int userGuess = 0;  // variable to get users input as userGuess
        int randNum = (int) (Math.random() * ((100 - 1) + 1)) + 1;   // generate random number from 1 - 100

        // Print out rules to the game (pretty basic)
        System.out.println("\nI'm thinking of a number from 1 to 100.");
        System.out.println("Try to guess it.");

        // uncomment to debug program
//        System.out.println(randNum);


        // main while loop that will compare userGuess and randNum until the user gets the right number
        // then print out number of tries it took as well as message based on number of tries
        while (userGuess != randNum) {
            userGuess = getIntWithinRange(sc, "\nEnter Number: ", 1, 100);
            tries++;
            if (userGuess == randNum) {
                System.out.println("You got it in " + tries + " tries.");
                if (tries <= 3) {
                    System.out.println("Great work! You are a mathematical wizard.");
                } else if (tries > 3 && tries <= 7) {
                    System.out.println("Not too bad! You've got some potential.");
                } else {
                    System.out.println("What took you so long? Maybe you should take some lessons.");
                }
                // print too high or too low based on difference between userGuess and randNum
            } else if (userGuess >= (randNum + 1) && userGuess <= (randNum + 9)) {
                System.out.println("Too high! Guess again.");
            } else if (userGuess >= (randNum + 10)) {
                System.out.println("Way too high! Guess again.");
            } else if (userGuess <= (randNum - 1) && userGuess >= (randNum - 9)) {
                System.out.println("Too low! Guess again.");
            } else if (userGuess <= (randNum - 10)) {
                System.out.println("Way too low! Guess again.");
            }
        }
    }


    // get a valid int from user input
    public static int getIntWithinRange(Scanner sc, String prompt, int min, int max) {
        while (true) {
            int userGuess = 0;
            try {
                System.out.print(prompt);
                userGuess = sc.nextInt();

                // if/else to make sure input is between 1 - 100
                if (userGuess >= min && userGuess <= max) {
                    return userGuess;
                } else {
                    // remind user to enter between 1 - 100
                    System.out.println("The number I'm thinking of is between 1 - 100, please try again.");
                    continue;
                }
            } catch (InputMismatchException e) { // catch input that isn't type int
                sc.next();      // discard invalid input
                System.out.println("Invalid input, please try again.");
            }
        }
    }


    // get valid input from user to decide if they want to continue playing
    public static String getContinueChar() {
        Scanner sc = new Scanner(System.in); // redeclare scanner or error message will print early
        while (true) {
            System.out.print("\nTry again? (y/n): "); // simple try again promt
            String cont = sc.nextLine();

            // if/else that only accepts y/n Y/N and will not allow an empty entry
            if (cont.equals("y") || cont.equals("n") || cont.equals("Y") || cont.equals("N")) {
                return cont;
            } else if (cont.isEmpty()){
                System.out.print("Error! This entry is required. Try again.");
            }
            else {
                System.out.print("Error! Entry Must be 'y' or 'n'. Try again.");
            }
        }
    }
}
