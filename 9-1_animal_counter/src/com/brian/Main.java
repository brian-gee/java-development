package com.brian;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("Counting alligators...\n");
        Alligator a = new Alligator();
        AnimalCounterApp.count(a, 3);

        System.out.println("\nCounting sheep...\n");
        Sheep s = new Sheep();
        s.setName("Blackie");
        AnimalCounterApp.count(s, 2);

        System.out.println();

        Sheep c = (Sheep) s.clone();
        c.resetCount();
        c.setName("Dolly");
        AnimalCounterApp.count(c, 3);

        System.out.println();
        s.resetCount();
        AnimalCounterApp.count(s, 1);
    }
}