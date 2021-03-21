package com.brian;

public class RoshamboApp {
    private Console c = new Console();
    private Player1 p1 = new Player1();
    private Player p = null;
    private Bart b = new Bart();
    private Lisa l = new Lisa();
    private String bartOrLisa;
    private String bartOrLisaChoice;

    public void game(){
        welcome();

        String playerChoice = generatePlayer1();
        if (bartOrLisa.equals("b")) {
            p = b;
            bartOrLisaChoice = generateBart();
        } else if (bartOrLisa.equals("l")) {
            p = l;
            bartOrLisaChoice = generateLisa();
        }
        System.out.println(playerChoice + "\n" + bartOrLisaChoice);

        if (getLastChar(playerChoice).equals(getLastChar(bartOrLisaChoice))) {
            System.out.println(p.getName() + "Draw!");
        }
    }

    private void welcome() {
        System.out.println("Welcome to the game of Roshambo\n");
        p1.setName(c.getString("Enter your name: "));
        System.out.println();
        bartOrLisa = c.getBL("Would you like to play Bart or Lisa? (B/L): ");
        System.out.println();
    }

    private String generatePlayer1() {
        return p1.generateRoshambo();
    }

    private String generateBart() {
        return b.generateRoshambo();
    }

    private String generateLisa() {
        return l.generateRoshambo();
    }

    private String getLastChar(String string) {
        return string.substring(string.length() - 1);
    }
}