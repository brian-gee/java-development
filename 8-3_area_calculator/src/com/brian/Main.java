package com.brian;

public class Main {
    public static void main(String[] args) {
        personManager();
    }

    public static void personManager() {
        Console c = new Console();
        System.out.println("Welcome to the Area Calculator");
        String userChoice;
        String cont = "y";

        while (cont.equals("y") || (cont.equals("Y"))) {
            userChoice = c.getCSR("\nCalculate area of a circle, square, or rectangle? (c/s/r): ");
            switch (userChoice) {
                case "c":
                    createCircle();
                    break;
                case "s":
                    createSquare();
                    break;
                case "r":
                    createRectangle();
                    break;
            }
            cont = c.getString();
        }
    }

    public static void createCircle() {
        Console c = new Console();
        double radius = c.getDouble("\nEnter radius: ", 0);
        Circle cir = new Circle(radius);
        cir.setRadius(radius);
        System.out.println("\nThe area of the Circle you entered is " + cir.getArea());
    }
    public static void createSquare() {
        Console c = new Console();
        double width = c.getDouble("\nEnter width: ", 0);
        Square sq = new Square(width);
        sq.setWidth(width);
        System.out.println("\nThe area of the Square you entered is " + sq.getArea());
    }
    public static void createRectangle() {
        Console c = new Console();
        double width = c.getDouble("\nEnter width: ", 0);
        double height = c.getDouble("\nEnter height: ", 0);
        Rectangle rect = new Rectangle(width, height);
        rect.setWidth(width);
        rect.setHeight(height);
        System.out.println("\nThe area of the Rectangle you entered is " + rect.getArea());
    }
}
