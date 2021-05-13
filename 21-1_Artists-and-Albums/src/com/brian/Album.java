package com.brian;

public class Album {
    private int albumID;
    private int artistID;
    private String albumName;

    public Album(int albumID, int artistID, String albumName) {
        this.albumID = albumID;
        this.artistID = artistID;
        this.albumName = albumName;

    }

    public int getAlbumID() {
        return albumID;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }

    public int getArtistID() {
        return artistID;
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
}