package com.brian;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MusicDB {

    private List<Artist> artists = new ArrayList<>();
    private List<Album> albums = new ArrayList<>();

    public List<Artist> getArtists() {
        artists = getAllArtists();
        artists.sort(Comparator.comparing(Artist::getArtistName));
        return artists;
    }

    public List<Album> getAlbums() {
        albums = getAllAlbums();
        albums.sort(Comparator.comparing(Album::getAlbumName));
        return albums;
    }

    private List<Artist> getAllArtists() {
        String sql = "SELECT ArtistID, Name FROM Artists";
        List<Artist> l = new ArrayList<>();
        try (Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()) {
                Artist a = new Artist(rs.getInt("ArtistID"), rs.getString("Name"));
                l.add(a);
            }
            return l;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Album> getAllAlbums() {
        String sql = "SELECT AlbumID, ArtistID, Name FROM Albums";
        List<Album> l = new ArrayList<>();
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()) {
                Album a = new Album(rs.getInt("AlbumId"), rs.getInt("ArtistID"), rs.getString("Name"));
                l.add(a);
            }
            return l;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Connection connect() throws SQLException {
        String dbUrl = "jdbc:sqlite:music_artists.sqlite";
        Connection connection = DriverManager.getConnection(dbUrl);
        return connection;
    }
}