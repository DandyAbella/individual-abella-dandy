package com.joysistvi.recordingstudio.model;

public class Artist {

    private int artistId;
    private String artistName;
    private String genre;
    private String country;
    private boolean archived;

    public Artist() {
    }

    public Artist(int artistId, String artistName,
                  String genre, String country,
                  boolean archived) {

        this.artistId = artistId;
        this.artistName = artistName;
        this.genre = genre;
        this.country = country;
        this.archived = archived;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }
}