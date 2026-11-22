package com.joysistvi.recordingstudio.service;

import com.joysistvi.recordingstudio.model.Song;

import java.util.List;

public interface SongService {

    List<Song> getAllSongs();

    void createSong(
            String songTitle,
            int artistId,
            int albumId,
            String duration
    );

    void deleteSong(int songId);

    List<Song> searchSongs(String keyword);
}