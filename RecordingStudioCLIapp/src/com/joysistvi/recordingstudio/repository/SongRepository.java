package com.joysistvi.recordingstudio.repository;

import com.joysistvi.recordingstudio.model.Song;

import java.util.List;

public interface SongRepository {

    List<Song> findAll();

    void save(Song song);

    void deleteById(int songId);

    List<Song> searchSongs(String keyword);
}