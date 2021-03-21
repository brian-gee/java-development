package com.brian;

import java.util.Random;

public class Lisa extends Player {

    public Lisa() {
        this.setName("Lisa");
    }

    @Override
    String generateRoshambo() {
        Random r = new Random();
        int ch = r.nextInt(3);
        if (ch == 0) return getName() + ": " + Roshambo.ROCK.toString();
        else if (ch == 1) return getName() + ": " + Roshambo.PAPER.toString();
        else return getName() + ": " + Roshambo.SCISSORS.toString();
    }
}