package com.Satkeev.songr;

import java.util.Map;

public interface AlbumRepository extends CrudRepository<Album, Long> {

    Map<Object, Object> findById(long id);

    Object findAll();

    void save(Album newAlbum);
}