package com.brian;

public class Bart extends Player {

    public Bart() {
       this.setName("Bart");
    }

    @Override
    public String generateRoshambo() {
        return getName() + ": " + Roshambo.ROCK.toString();
    }
}