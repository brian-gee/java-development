package com.brian;

import java.util.Scanner;

public class Main {

    public static void travelTimeCalc() {
        while (true) {
            // Declare scanner object and print out prompts for miles and mph
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter miles:           ");
            double miles = sc.nextDouble();
            System.out.print("Enter miles per hour:  ");
            double miles_per_hour = sc.nextDouble();

            // Calculate time in hours and minutes
            double timeHour = (miles/miles_per_hour);
            double timeMin = ((timeHour - Math.floor(timeHour)) * 60);

            // Cast timeHour and timeMin from double to int
            int intTimeHour = (int)timeHour;
            int intTimeMin = (int)timeMin;


            // Print out estimated time in hours and minutes
            System.out.println("\nEstimated travel time");
            System.out.println("---------------------");
            System.out.println("Hours: " + intTimeHour);
            System.out.println("Minutes: " + intTimeMin+ "\n");

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
        System.out.println("Welcome to the Travel Time Calculator\n");

        // Run travelTimeCalc method
        travelTimeCalc();
    }
}
