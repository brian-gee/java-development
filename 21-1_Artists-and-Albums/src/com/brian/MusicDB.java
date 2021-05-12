package com.brian;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MusicDB {

    private static Connection con;
    private static boolean hasData = false;

    public MusicDB() {
        try {
            getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    private Connection getConnection() throws SQLException {
        String dbUrl = "jdbc:sqlite:music_artists.sqlite";
        Connection connection = DriverManager.getConnection(dbUrl);
        System.out.println("it worked");
        return connection;
    }
}