package com.joysistvi.recordingstudio.service;

import com.joysistvi.recordingstudio.model.Song;
import com.joysistvi.recordingstudio.repository.SongRepository;

import java.util.List;

public class SongServiceImpl implements SongService {

    private SongRepository repository;

    public SongServiceImpl(SongRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Song> getAllSongs() {
        return repository.findAll();
    }

    @Override
    public void createSong(
            String songTitle,
            int artistId,
            int albumId,
            String duration
    ) {

        Song song = new Song();

        song.setSongTitle(songTitle);
        song.setArtistId(artistId);
        song.setAlbumId(albumId);
        song.setDuration(duration);

        repository.save(song);
    }

    @Override
    public void deleteSong(int songId) {
        repository.deleteById(songId);
    }

    @Override
    public List<Song> searchSongs(String keyword) {
        return repository.searchSongs(keyword);
    }
}