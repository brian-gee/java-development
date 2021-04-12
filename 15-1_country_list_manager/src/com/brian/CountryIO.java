package com.brian;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CountryIO {
    private String fileName = "src/com/brian/countries.txt";
    private ArrayList<String> countries = new ArrayList<>();

    public CountryIO() {
        String dirString = "/home/brian/mega/java/15-1_country_list_manager/src/com/brian";
        String fileString = "countries.txt";
        Path filePath = Paths.get(dirString, fileString);
        if (Files.notExists(filePath)) {
            try {
                Files.createFile(filePath);
                PrintWriter out = new PrintWriter(
                                  new BufferedWriter(
                                  new FileWriter(fileName)));
                out.println("United States");
                out.println("Canada");
                out.println("Mexico");
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            String line = in.readLine();
            while (line != null) {
                countries.add(line);
                line = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getCountries() {
        return countries;
    }



    public boolean saveCountries(ArrayList<String> countries) {
        return true;
    }
}