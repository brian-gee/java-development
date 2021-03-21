package com.brian;

public class Player1 extends Player {

    private String name;

    @Override
    String generateRoshambo() {
        Console c = new Console();
        String choice = null;
        String playerInput = c.getRPS("Rock, paper, or scissors? (R/P/S): ");

        switch (playerInput) {
            case "r" -> choice = Roshambo.ROCK.toString();
            case "p" -> choice = Roshambo.PAPER.toString();
            case "s" -> choice = Roshambo.SCISSORS.toString();
        }
        System.out.println();
        return name + ": " + choice;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}