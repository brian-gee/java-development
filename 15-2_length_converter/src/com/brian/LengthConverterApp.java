package com.brian;

import java.util.List;

public class LengthConverterApp {

    private static ConversionTextFile conversionFile = new ConversionTextFile();
    private static List<Conversion> conversions = conversionFile.getAll();

    public static void main(String args[]) {
        System.out.println("Length Converter");

        int action = 0;
        while (action != 4) {
            displayMenu();
            action = Console.getInt("Enter menu number: ", 0, 5);
            System.out.println();

            if (action == 1) {
                convertLength();
            } else if (action == 2) {
                addConversion();
            } else if (action == 3) {
                deleteConversion();
            } else if (action == 4) {
                System.out.println("Goodbye.\n");
            } else {
                System.out.println("Error! Not a valid command.\n");
            }
        }
    }
    public static void displayMenu() {
        System.out.println("\n1 - Convert a length");
        System.out.println("2 - Add a type of conversion");
        System.out.println("3 - Delete a type of conversion");
        System.out.println("4 - Exit\n");
    }

    public static void convertLength() {
        displayAllConversions();
        int choice = Console.getInt("Enter conversion number: ");
        choice--;
        Conversion c = conversions.get(choice);
        System.out.println(c.convert(Console.getDouble("\nEnter " + StringUtils.capitalize(c.fromUnit) + ": ")));
    }

    public static void displayAllConversions() {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Conversion c : conversions) {
            sb.append(i + " - " + StringUtils.capitalize(c.getFromUnit()));
            sb.append(" to " + StringUtils.capitalize(c.getToUnit()));
            sb.append(": " + c.getConversionRatio());
            sb.append("\n");
            i++;
        }
        System.out.println(sb);
    }

    public static void addConversion() {
        String from = Console.getString("Enter 'From' unit: ");
        String to = Console.getString("Enter 'To' unit: ");
        double ratio = Console.getDouble("Enter the conversion ratio: ");
        Conversion c = new Conversion(from, to, ratio);
        conversionFile.add(c);
        System.out.println("\nThis entry has been saved");
    }

    public static void deleteConversion() {
        displayAllConversions();
        int choice = Console.getInt("Enter conversion number to delete: ");
        choice--;
        Conversion c = conversions.get(choice);
        conversionFile.delete(c);
    }

}