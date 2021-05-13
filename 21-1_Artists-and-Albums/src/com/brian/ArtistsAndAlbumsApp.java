package com.brian;

import java.util.List;

public class ArtistsAndAlbumsApp {
    MusicDB db = new MusicDB();
    private List<Artist> artists = db.getArtists();
    private List<Album> albums = db.getAlbums();

    public ArtistsAndAlbumsApp() {
        System.out.println("Artist and Album Listing");
        printArtists();
        printAlbums();
        printArtistsAndAlbums();
    }

    public void printArtists() {
        System.out.println("\nArtists\n" + "-------" );
        for (Artist artist : artists) {
            System.out.println(artist.getArtistName());
        }
    }

    public void printAlbums() {
        System.out.println("\nAlbums\n" + "------");
        for (Album album : albums) {
            System.out.println(album.getAlbumName());
        }
    }

    public void printArtistsAndAlbums() {
        System.out.println("\nAlbums by Artist\n" + "----------------");
        for (Artist artist : artists) {
            System.out.println(artist.getArtistName());
            for (Album album : albums){
               if (album.getArtistID() == artist.getArtistID()) {
                   System.out.println("\t" + album.getAlbumName());
               }
            }
        }
    }
}