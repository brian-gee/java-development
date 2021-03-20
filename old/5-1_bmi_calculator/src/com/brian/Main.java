package com.brian;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void bmiCalc() {
        while (true) {
            // Declare scanner object and prompt user for weightInPounds and heightInInches
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your weight in pounds: ");
            double weightInPounds = sc.nextDouble();
            System.out.print("Enter your height in inches: ");
            double heightInInches = sc.nextDouble();
            System.out.println();

            // Calculate users BMI from user input and round the number
            double bmi = (weightInPounds * 703) / (heightInInches * heightInInches);
            DecimalFormat df = new DecimalFormat("0.0");
            String bmiRounded = df.format(bmi);

            // Print out user's BMI and the standard BMI values
            System.out.println("Your BMI is " + bmiRounded);
            System.out.println("\nBMI VALUES" +
                    "\nUnderweight: less than 18.5" +
                    "\nNormal: between 18.5 and 24.9" +
                    "\nOverweight: between 25 and 29.9" +
                    "\nObese: 30 or greater");

            // Print continue prompt and break if user doesn't enter y
            System.out.print("\nContinue? (y/n): ");
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
        System.out.println("Body Mass Index Calculator\n");

        // Run bmiCalc method
        bmiCalc();


    }
}
