package com.brian;

public class Game {
    public void displayWelcome() {
        System.out.println("Welcome to the Guess the Number Game\n" +
                "++++++++++++++++++++++++++++++++++++");
    }

    public int getRandomInt(int limit) {
        double d = Math.random() * limit;   // d is >= 0.0 and < limit
        int randomInt = (int) d;            // convert double to int
        randomInt++;                        // int is >= 1 and <= limit
        return randomInt;
    }

    public void guessingGame() {
        int tries = 0;  // variable to keep track of users guesses
        int userGuess = 0;  // variable to get users input as userGuess
        int randNum = getRandomInt(100);  // generate random number from 1 - 100

        // Print out rules to the game (pretty basic)
        System.out.println("\nI'm thinking of a number from 1 to 100.");
        System.out.println("Try to guess it.");

        // uncomment to debug program
//        System.out.println(randNum);

        // main while loop that will compare userGuess and randNum until the user gets the right number
        // then print out number of tries it took as well as message based on number of tries
        while (userGuess != randNum) {
            userGuess = Console.getInt("\nEnter Number: ", 1, 100);
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

    public void guessingGameLoop() {
            while (true) { // main loop to run guessingGame and ask to continue after correct guess
                guessingGame();
                // use Console class to getContinueCharacter
                String cont = Console.getString();
                System.out.println();
                if (cont.equals("y") || (cont.equals("Y"))) { // continue if user enters y or Y
                    continue;
                } else if (cont.equals("n") || (cont.equals("N"))) { // break if user enters n or N
                    System.out.println("Bye - Come back soon!");
                    break;
                } else { // otherwise prompt again if entry is not y/Y or n/N
                    Console.getString();
                }
            }
        }
    }