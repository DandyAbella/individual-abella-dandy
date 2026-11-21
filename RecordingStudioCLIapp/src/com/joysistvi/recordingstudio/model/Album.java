package com.joysistvi.recordingstudio.model;

public class Album {

    private int albumId;
    private String albumName;
    private int year;
    private int artistId;
    private String artistName;
    private boolean archived;

    public Album() {
    }

    public Album(int albumId,
                 String albumName,
                 int year,
                 int artistId,
                 String artistName,
                 boolean archived) {

        this.albumId = albumId;
        this.albumName = albumName;
        this.year = year;
        this.artistId = artistId;
        this.artistName = artistName;
        this.archived = archived;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }
}