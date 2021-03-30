package com.brian;

public class WizardInventory {
    // Declare new Console c and new Item i
    Console c = new Console();
    Item i = new Item();

    // Main program to run WizardInventory app
    public void wizardInventory() {
        System.out.println("The Wizard Inventory game\n");
        printCommands(); //
        i.defaultItems(); // Add the default items to Item i
        getCommand();
    }

    // Get a command from the user and preform an action based off user's command
    private void getCommand() {
        String command = c.getString("Command: ");
        while (!command.equals("exit")) {
            if (command.equals("show")) {
                i.showItems();
            } else if ("grab".equals(command)) {
                if (i.getSize() < 4) {
                    i.grabItem(c.getString("Name: "));
                } else {
                    System.out.println("You can't carry any more items. Drop something first.");
                }
            } else if (command.equals("edit")) {
                i.editItem(c.getInt("Number: ", 1, 4), c.getString("Updated name: "));
            } else if (command.equals("drop")) {
                if (i.getSize() != 0) {
                    i.dropItem(c.getInt("Number: ", 1, 4));
                } else {
                    System.out.println("You don't have anymore items to drop.");
                }
            } else {
                System.out.println("Please enter a valid command.");
            }
            command = c.getString("\nCommand: ");
        }
        System.out.println("Bye!");
    }

    // Print out all the commands available to user
    private void printCommands() {
        System.out.println("COMMAND MENU");
        System.out.println("show - Show all items");
        System.out.println("grab - Grab an item");
        System.out.println("edit - Edit an item");
        System.out.println("drop - Drop an item");
        System.out.println("exit - Exit program\n");
    }
}