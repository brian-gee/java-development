package com;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public final class TeamLineupTextFile {
    private String fileName = "src/com/teamLineup.txt";
    private ArrayList<String> teamLineup = new ArrayList<>();
    String dirString = "/home/brian/mega/java/19-1_TeamLineup/src/com";
    String fileString = "teamLineup.txt";
    Path filePath = Paths.get(dirString, fileString);
    List<Player> players;

    public TeamLineupTextFile() {
        players = this.getAll();
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

    public List<Player> getAll() {
        // if the players file has already been read, don't read it again
        if (players!= null) {
            return players;
        }
        players = new ArrayList<>();
        if (Files.exists(filePath)) {
            try (BufferedReader in = new BufferedReader(
                    new FileReader(fileName))) {

                // read players from file into array list
                String line = in.readLine();
                while (line != null) {
                    String[] fields = line.split(",");
                    String name = fields[0].strip();
                    String position = fields[1].strip();
                    Player c = new Player(name, position);
                    players.add(c);
                    line = in.readLine();
                }
            } catch (IOException e) {
                System.out.println(e);
                return null;
            }
        } else {
            return null;
        }
        return players;
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