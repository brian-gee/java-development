package com.brian;

public class Main {
    public static void main(String[] args) {
        personManager();
    }

    public static void personManager() {
        Console c = new Console();
        System.out.println("Welcome to the Person Manager");
        String userChoice;
        String cont = "y";

        while (cont.equals("y") || (cont.equals("Y"))) {
            userChoice = c.getCE("\nCreate customer or employee? (c/e): ");
            if (userChoice.equals("c")) {
                createCustomer();
            } else if (userChoice.equals("e")) {
                createEmployee();
            }
            cont = c.getString();
        }
    }

    public static void createCustomer() {
        Console c = new Console();
        String first, last, number;
        first = c.getString("\nFirst name: ");
        last = c.getString("Last name: ");
        number = c.getString("Customer number: ");
        Customer cx = new Customer(first, last, number);
        System.out.println("\nYou entered a new Customer:");
        System.out.println(cx);
    }

    public static void createEmployee() {
        Console c = new Console();
        String first, last, ssn;
        first = c.getString("\nFirst name: ");
        last = c.getString("Last name: ");
        ssn = c.getString("SSN: ");
        Employee emp = new Employee(first, last, ssn);
        System.out.println("\nYou entered a new Employee:");
        System.out.println(emp);
    }
}