package com.brian;

public class CountriesApp {

    public static void main(String[] args) {
        String cont = "y";
        Console c = new Console();
        CountriesTextFile cto = new CountriesTextFile();
        System.out.println("Country List Manager\n");

        while (true) {

            printCommands();
            int choice = c.getInt("Enter menu number: ", 1, 4);
            System.out.println();
            if (choice == 1){
                cto.listCountries();
            } else if (choice == 2){
                cto.addCountry(c.getString("Enter country: "));
            } else if (choice == 3) {
                int countryNum  = c.getInt("Enter the country number you would like to delete: ", 1, 100);
                cto.deleteCountry((countryNum - 1));
            } else if (choice == 4) {
                System.out.println("Goodbye.");
                break;
            } else {
                System.out.println("Please make a valid selection");
            }
        }
    }

    public static void printCommands() {
        System.out.println("""

                COMMAND MENU
                1 - List countries
                2 - Add a country
                3 - Delete a country
                4 - Exit
                """);
    }
}