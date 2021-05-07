package com;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.List;

public final class GroceryListTextFile{
    private String fileName = "src/com/groceryList.txt";
    private ArrayList<String> teamLineup = new ArrayList<>();
    String dirString = "/home/brian/mega/java/19-2_GroceryList/src/com";
    String fileString = "groceryList.txt";
    Path filePath = Paths.get(dirString, fileString);
    List<Item> items;

    public GroceryListTextFile() {
        items = this.getAll();
        if (Files.notExists(filePath)) {
            try {
                Files.createFile(filePath);
                PrintWriter out = new PrintWriter(
                        new BufferedWriter(
                                new FileWriter(fileName)));
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            String line = in.readLine();
            while (line != null) {
                teamLineup.add(line);
                line = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Item> getAll() {
        // if the players file has already been read, don't read it again
        if (items != null) {
            return items;
        }
        items = new ArrayList<>();
        if (Files.exists(filePath)) {
            try (BufferedReader in = new BufferedReader(
                    new FileReader(fileName))) {

                // read players from file into array list
                String line = in.readLine();
                while (line != null) {
                    String name = line.strip();
                    Item i = new Item(name);
                    items.add(i);
                    line = in.readLine();
                }
            } catch (IOException e) {
                System.out.println(e);
                return null;
            }
        } else {
            return null;
        }
        return items;
    }

    public boolean saveAll(String content) {
        try (PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(fileName)))) {
            out.print(content);
            return true;
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
    }
}