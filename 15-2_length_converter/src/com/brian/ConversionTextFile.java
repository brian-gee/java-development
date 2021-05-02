package com.brian;

import com.brian.Conversion;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public final class ConversionTextFile {
    private List<Conversion> conversions;
    private Path conversionsPath;
    private File conversionsFile;
    private final String FIELD_SEP = "\t";

    public ConversionTextFile() {
        conversionsPath = Paths.get("src/com/brian/conversion_types.txt");
        conversionsFile = conversionsPath.toFile();
        conversions = this.getAll();
    }

    public List<Conversion> getAll() {
        // if the conversions file has already been read, don't read it again
        if (conversions!= null) {
            return conversions;
        }

        conversions = new ArrayList<>();
        if (Files.exists(conversionsPath)) {
            try (BufferedReader in = new BufferedReader(
                    new FileReader(conversionsFile))) {

                // read conversions from file into array list
                String line = in.readLine();
                while (line != null) {
                    String[] fields = line.split(FIELD_SEP);
                    String from = fields[0];
                    String to = fields[1];
                    String ratio = fields[2];
                    Conversion c = new Conversion(
                            from, to, Double.parseDouble(ratio));
                    conversions.add(c);
                    line = in.readLine();
                }
            } catch (IOException e) {
                System.out.println(e);
                return null;
            }
        } else {
            // create conversions file if it doesn't exist
            try {
                Files.createFile(conversionsPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        return conversions;
    }

    private boolean saveAll() {
        try (PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(conversionsFile)))) {

            // write all conversions in the array list to the file
            for (Conversion c : conversions) {
                out.print(c.getFromUnit() + FIELD_SEP);
                out.print(c.getToUnit() + FIELD_SEP);
                out.println(c.getConversionRatio());
            }
            return true;
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean add(Conversion c) {
        conversions.add(c);
        return this.saveAll();
    }

    public boolean delete(Conversion c) {
        conversions.remove(c);
        return this.saveAll();
    }
}