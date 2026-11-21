package com.joysistvi.recordingstudio.service;

import com.joysistvi.recordingstudio.model.Album;
import com.joysistvi.recordingstudio.repository.AlbumRepository;

import java.util.List;

public class AlbumServiceImpl implements AlbumService {

    private AlbumRepository repository;

    public AlbumServiceImpl(AlbumRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Album> getAllActiveAlbums() {
        return repository.findAllActive();
    }

    @Override
    public List<Album> getAllArchivedAlbums() {
        return repository.findAllArchived();
    }

    @Override
    public void createAlbum(
            String albumName,
            int year,
            int artistId) {

        if (albumName == null ||
                albumName.trim().isEmpty()) {

            System.out.println("Validation Error");
            return;
        }

        if (year < 1900 || year > 2100) {

            System.out.println("Validation Error");
            return;
        }

        if (artistId <= 0) {

            System.out.println("Validation Error");
            return;
        }

        Album album = new Album();

        album.setAlbumName(albumName);
        album.setYear(year);
        album.setArtistId(artistId);

        repository.save(album);
    }

    @Override
    public void updateAlbum(
            int albumId,
            String albumName,
            int year,
            int artistId) {

        Album album = new Album();

        album.setAlbumId(albumId);
        album.setAlbumName(albumName);
        album.setYear(year);
        album.setArtistId(artistId);

        repository.update(album);
    }

    @Override
    public void deleteAlbum(int albumId) {

        if (albumId <= 0) {
            System.out.println("Validation Error");
            return;
        }

        repository.deleteById(albumId);
    }


    @Override
    public void archiveAlbum(int albumId) {

        if (albumId <= 0) {
            System.out.println("Validation Error");
            return;
        }

        repository.archiveById(albumId);
    }

    @Override
    public void restoreAlbum(int albumId) {

        if (albumId <= 0) {
            System.out.println("Validation Error");
            return;
        }

        repository.restoreById(albumId);
    }

    @Override
    public List<Album> searchAlbums(String keyword) {

        if (keyword == null ||
                keyword.trim().isEmpty()) {

            System.out.println("Validation Error");
            return null;
        }

        return repository.searchByName(keyword);
    }
}