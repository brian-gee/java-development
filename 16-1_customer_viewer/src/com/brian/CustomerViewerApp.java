package com.brian;

public class CustomerViewerApp {



    public static void main(String args[]) {
        System.out.println("Customer Viewer");
        String cont = "y";
        while (cont.equals("y") || cont.equals("Y")) {
            displayCustomer();
            cont = Console.getContinueString("Display another customer? (y/n): ");
        }
        System.out.println("Bye!");
    }

    public static void displayCustomer() {
        int customerNumber = 0;
        try {
            customerNumber = Console.getInt("\nEnter a customer number: ");
            Customer c = CustomerDB.getCustomer(customerNumber);
            System.out.println("\n" + c.getName());
            System.out.println(c.getAddress());
            System.out.println(c.getCity() + ", " + c.getState() + " " + c.getPostalCode());
        } catch (CustomerNotFoundException e) {
            System.out.println("\nNo customer found for number " + customerNumber);
        }

    }
}