package com.joysistvi.recordingstudio;

public class Artist {

    private int artistId;
    private String artistName;
    private String genre;
    private String country;

    public Artist(int artistId, String artistName,
                  String genre, String country) {
        this.artistId = artistId;
        this.artistName = artistName;
        this.genre = genre;
        this.country = country;
    }

    public int getArtistId() {
        return artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getGenre() {
        return genre;
    }

    public String getCountry() {
        return country;
    }
}