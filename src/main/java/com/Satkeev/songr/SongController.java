package com.Satkeev.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

//A controller is responsible for processing incoming requests.
@Controller
public class SongController {

////annotation provides more fine-grained control over where and how autowiring should be accomplished
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;

//@GetMapping - shortcut for @RequestMapping(method = RequestMethod.GET)
    @GetMapping("/allSongs")
    public String getAllSongs(Model m) {
        m.addAttribute("songs", songRepository.findAll());
        return "allSongs";
    }
    //@RequestMapping(method = RequestMethod.POST
    @PostMapping("/addSong")
    public String getAddSong(@RequestParam long id, Model m) {
        Album album = albumRepository.findById(id).get();
        m.addAttribute("album", album);
        return "songForm";
    }
    //@RequestMapping(method = RequestMethod.POST
    @PostMapping("/addSongNow")

    //   View that redirects to an absolute, context relative, or current request relative URL.
    public RedirectView addNewSong(@RequestParam String title,
                                   @RequestParam int length,
                                   @RequestParam int trackNumber,
                                   @RequestParam long albumId) {
        Album album = albumRepository.findById(albumId).get();
        Song newSong = new Song(title, length, trackNumber, album);
        album.setLength(album.getLength() + length);
        album.setSongCount(album.getSongCount() + 1);
        albumRepository.save(album);
        songRepository.save(newSong);
        return new RedirectView("/allAlbums");
    }
}


