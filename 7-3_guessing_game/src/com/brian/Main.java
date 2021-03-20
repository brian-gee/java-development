package com.brian;

public class Main {

    public static void main(String[] args) {
        Game g = new Game(); // create new game instance
        g.displayWelcome(); // print welcome message
        g.guessingGameLoop(); // run guessing game using new game instance
    }
}