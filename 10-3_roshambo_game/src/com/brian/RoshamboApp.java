package com.brian;

public class RoshamboApp {
    private Console c = new Console();
    private Player1 p1 = new Player1();
    private Player p = null;
    private Bart b = new Bart();
    private Lisa l = new Lisa();
    private String bartOrLisa;
    private int wins, losses, draws;
    private String contString = "y";

    public void game(){
        welcome();

        while (contString.equals("y")) {
            String p1Choice = p1.generateRoshambo();
            String p1ChoiceLast = getLastChar(p1Choice);
            String pChoice = p.generateRoshambo();
            String pChoiceLast = getLastChar(pChoice);
            System.out.println(p1Choice+ "\n" + pChoice);

            if (p1ChoiceLast.equals(pChoiceLast)) {
                System.out.println("Draw!");
                draws++;
            } else if (p1ChoiceLast.equals("k") && pChoiceLast.equals("s")) {
                System.out.println(p1.getName() + " wins!");
                wins++;
            } else if (p1ChoiceLast.equals("s") && pChoiceLast.equals("r")) {
                System.out.println(p1.getName() + " wins!");
                wins++;
            } else if (p1ChoiceLast.equals("r") && pChoiceLast.equals("k")) {
                System.out.println(p1.getName() + " wins!");
                wins++;
            } else if (pChoiceLast.equals("k") && p1ChoiceLast.equals("s")) {
                System.out.println(p.getName() + " wins!");
                losses++;
            } else if (pChoiceLast.equals("s") && p1ChoiceLast.equals("r")) {
                System.out.println(p.getName() + " wins!");
                losses++;
            } else if (pChoiceLast.equals("r") && p1ChoiceLast.equals("k")) {
                System.out.println(p.getName() + " wins!");
                losses++;
        } contString = c.getContinueString();
            System.out.println();

    }
        System.out.println("You had " + wins + " wins, " + losses + " losses and " + draws + " draws!");
}

    private void welcome() {
        System.out.println("Welcome to the game of Roshambo\n");

        p1.setName(c.getString("Enter your name: "));
        System.out.println();

        bartOrLisa = c.getBL("Would you like to play Bart or Lisa? (B/L): ");
        System.out.println();

        if (bartOrLisa.equals("b")) {
            p = b;
        } else if (bartOrLisa.equals("l")) {
            p = l;
        }
    }


    private String getLastChar(String string) {
        return string.substring(string.length() - 1);
    }
}