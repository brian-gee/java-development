package com.brian;

public class Main {

    public static void main(String[] args) {
        // welcome message for the program
        System.out.println("Welcome to the Contact List Application\n");

        while (true) { // main loop to run contactListApplication
            contactListApplication();

            // use Console class to getContinueCharacter
            String cont = Console.getContinueCharacter("\nContinue? (y/n): ");
            if (cont.equals("y") || (cont.equals("Y"))) { // continue if user enters y or Y
                continue;
            } else if (cont.equals("n") || (cont.equals("N"))) { // break if user enters n or N
                System.out.println("\nBye - Come back soon!");
                break;
            } else { // otherwise prompt again if entry is not y/Y or n/N
                Console.getContinueCharacter("\nContinue? (y/n): ");
            }
        }
    }

    public static void contactListApplication() {
        Contact c= new Contact(); // declare a new Contact named Contact c
        System.out.println(c.displayContact()); // print out the displayContact method for Contact c
    }
}