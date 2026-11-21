package com.joysistvi.recordingstudio.service;

import com.joysistvi.recordingstudio.model.Album;
import java.util.List;

public interface AlbumService {

    List<Album> getAllActiveAlbums();

    List<Album> getAllArchivedAlbums();

    void createAlbum(
            String albumName,
            int year,
            int artistId);

    void updateAlbum(
            int albumId,
            String albumName,
            int year,
            int artistId);

    void deleteAlbum(int albumId);

    void archiveAlbum(int albumId);

    void restoreAlbum(int albumId);

    List<Album> searchAlbums(String keyword);
}