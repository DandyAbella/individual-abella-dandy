package com.joysistvi.recordingstudio.repository;

import com.joysistvi.recordingstudio.model.Album;
import java.util.List;

public interface AlbumRepository {

    List<Album> findAllActive();

    List<Album> findAllArchived();

    void save(Album album);

    void update(Album album);

    void deleteById(int albumId);

    void archiveById(int albumId);

    void restoreById(int albumId);

    List<Album> searchByName(String keyword);
}