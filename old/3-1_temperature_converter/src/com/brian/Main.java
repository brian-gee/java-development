package com.brian;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void convertTemp() {
        while (true) {
            // Declare scanner object and print out prompt for grade
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter degrees in Fahrenheit: ");
            double fahren_temp = sc.nextDouble();
            double celsius_temp = (fahren_temp - 32.0) * (5.0/9.0);

            // Create number format for proper decimal printout
            NumberFormat nf = new DecimalFormat("##.##");
            String celsius_temp_round = nf.format(celsius_temp);
            System.out.println("Degrees in Celsius: " + celsius_temp_round + "\n");

            // Print continue prompt and break if user doesn't enter y
            System.out.print("Continue? (y/n): ");
            String cont = sc.next();
            if (cont.equals("y") || (cont.equals("Y"))) {
            } else {
                break;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
	    // Print program title and blank line
        System.out.println("Welcome to the Temperature Converter\n");
        // Run convertTemp method
        convertTemp();
    }
}
