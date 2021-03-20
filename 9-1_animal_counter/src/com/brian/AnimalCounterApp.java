package com.brian;

public class AnimalCounterApp {
    public static void count(Countable c, int maxCount) {
        for (int i = 0; i < maxCount; i++){
            System.out.println(c.getCountString());
        }
    }
}