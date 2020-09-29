package com.Satkeev.songr;

public interface SongRepository extends CrudRepository<Song, Long> {
    void save(Song newSong);

    Object findAll();
}
