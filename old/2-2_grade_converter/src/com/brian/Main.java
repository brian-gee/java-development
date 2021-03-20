package com.brian;

import java.util.Scanner;

public class Main {

    public static void gradeConvert() {
        while (true) {
            // Declare scanner object and print out prompt for grade
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter numerical grade: ");
            int num_grade = sc.nextInt();

            // if/else statement to get letter grade for enter num_grade
            if (num_grade <= 100 && num_grade >= 88) {
                System.out.println("Letter Grade: A\n");
            } else if (num_grade <= 87 && num_grade >= 80) {
                System.out.println("Letter Grade: B\n");
            } else if (num_grade <= 79 && num_grade >= 67) {
                System.out.println("Letter Grade: C\n");
            } else if (num_grade <= 66 && num_grade >= 60) {
                System.out.println("Letter Grade: D\n");
            } else {
                System.out.println("Letter Grade: F\n");
            }

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
        System.out.println("Welcome to the Letter Grade Converter\n");
        // Run gradeConvert method
        gradeConvert();
    }
}
