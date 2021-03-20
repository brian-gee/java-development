package com.brian;

public class Bart extends Player {

    @Override
    String generateRoshambo() {
        return Roshambo.ROCK.toString();
    }
}