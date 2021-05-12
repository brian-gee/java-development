package com.brian;

public class Album {
    private int albumID;
    private int artistID;
    private int albumName;

    public Album(int albumID, int artistID, int albumName) {
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

    public int getAlbumName() {
        return albumName;
    }

    public void setAlbumName(int albumName) {
        this.albumName = albumName;
    }
}