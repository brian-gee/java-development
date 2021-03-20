package com.briange;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Print out title of program and a blank line
        System.out.println("Student Registration Form\n");

        //Create scanner object sc
        Scanner sc = new Scanner(System.in);

        //Prompt user for their first name
        System.out.print("Enter first name: ");
        String first_name = sc.next().trim();
        String first_name_cap = first_name.substring(0,1).toUpperCase() + first_name.substring(1);

        //Prompt user for their last name
        System.out.print("Enter last name: ");
        String last_name = sc.next().trim();
        String last_name_cap = last_name.substring(0,1).toUpperCase() + last_name.substring(1);

        //Prompt user for their birth year
        System.out.print("Enter year of birth: ");
        int birth_year = sc.nextInt();


        //Print out completed registration message to the user
        System.out.println("\n" +
                "Welcome, " + first_name_cap + " " + last_name_cap + "!\n" +
                "Your registration is complete.\n" +
                "Your temporary password is: " + first_name_cap + "*" + birth_year);
    }
}

