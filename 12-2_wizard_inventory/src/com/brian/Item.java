package com.brian;

import java.util.ArrayList;

public class Item {

    // Create Arraylist called items
    private ArrayList<String> items = new ArrayList<>();

    public void defaultItems() { // Add default items to items
        items.add("wooden staff");
        items.add("wizard hat");
        items.add("cloth shoes");
    }

    public void showItems() { // Shows all items in items
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i+1) + ". " + this.items.get(i));
        }
    }
    public void grabItem(String item) { // Grabs an item from items
        if (items.size() < 4) {
            items.add(item);
            System.out.println(item + " was added.");
        }
    }
    public int getSize() { // Get size of items
        return items.size();
    }
    public void dropItem(int i) { // Remove an item from items
        String droppedItem = items.get(i);
        items.remove((i));
        System.out.println("You dropped your " + droppedItem + ".");
}
    public void editItem(int num, String name){ // Edit an item in items
        items.remove(num);
        items.add(num, name);
        System.out.println("Item number " + (num+1) + " was updated.");
    }
}