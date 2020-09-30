package com.Satkeev.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumsController {
    @Autowired
    private AlbumRepository albumRepo;
    @Autowired
    private SongRepository songRepo;

    //Gets all albums from the database to render on the page
    @RequestMapping(value="/albums", method= RequestMethod.GET)
    public String index(Model m) {
        m.addAttribute("albums", albumRepo.findAll());
        return "albums";
    }

    //Adds a new album to the database
    @RequestMapping(value="/albums", method= RequestMethod.POST)
    public RedirectView create(
            @RequestParam String title,
            @RequestParam String artist,
            @RequestParam int songCount,
            @RequestParam int length,
            @RequestParam String imageUrl) {
        Album newAlbum = new Album(title, artist, songCount, length, imageUrl);
        albumRepo.save(newAlbum);
        return new RedirectView("/albums");
    }

    @RequestMapping(value="/albums/{id}", method=RequestMethod.GET)
    public String show(@PathVariable long id, Model m) {
        final var album = m.addAttribute("album", albumRepo.findById(id).get(albumRepo));
        final var songs = m.addAttribute("songs", albumRepo.findById(id).get(albumRepo));
        return "album";
    }

    @RequestMapping(value="/albums/{albumId}", method=RequestMethod.POST)
    public RedirectView addSong(@PathVariable long albumId,
                                @RequestParam String title,
                                @RequestParam int length,
                                @RequestParam int trackNumber) {
        Song newSong = new Song(title, length, trackNumber);
        newSong.album = (Album) albumRepo.findById(albumId).get(albumRepo);
        songRepo.save(newSong);

        return new RedirectView("/albums/" + albumId);
    }
}