package com.brian;

public class NumberChecker{
    MyConsole c = new MyConsole();
    public void displayWelcome() {
        System.out.println("Welcome to the Odd/Even Checker!\n");
    }

    public void numberChecker() {
        int userInt = -1;

        while (userInt == -1) {
            userInt = c.getInt("Enter an integer: ", 0);
            if (userInt % 2 == 0){
                System.out.println("The number " + userInt + " is even");
            } else {
                System.out.println("The number " + userInt + " is odd");
            }
        }
    }

    public void numberCheckerLoop() {
        while (true) { // main loop to run guessingGame and ask to continue after correct guess
            numberChecker();
            // use Console class to getContinueCharacter
            String cont = c.getString();
            System.out.println();
            if (cont.equals("y") || (cont.equals("Y"))) { // continue if user enters y or Y
                continue;
            } else if (cont.equals("n") || (cont.equals("N"))) { // break if user enters n or N
                System.out.println("Bye - Come back soon!");
                break;
            } else { // otherwise prompt again if entry is not y/Y or n/N
                c.getString();
            }
        }
    }
}