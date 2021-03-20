package com.brian;

public class Main {

    public static void main(String[] args) {
        Bart b = new Bart();
        b.setName("Bart");
        System.out.println(b.getName() + ": " + b.generateRoshambo());

    }
}