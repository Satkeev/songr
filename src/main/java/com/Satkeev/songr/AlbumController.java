package com.Satkeev.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

//A controller is responsible for processing incoming requests.
@Controller
public class AlbumController {

//annotation provides more fine-grained control over where and how autowiring should be accomplished
    @Autowired
    AlbumRepository albumRepository;

//@GetMapping - shortcut for @RequestMapping(method = RequestMethod.GET)
    @GetMapping("/allAlbums")
    public String getAllAlbums(Model m) {
        Iterable<Album> albumCollection = albumRepository.findAll();
        m.addAttribute("albums", albumCollection);
        return "allAlbums";
    }
    //@GetMapping - shortcut for @RequestMapping(method = RequestMethod.GET)
    @GetMapping("/addAlbum")
    public String getAddAlbum() {
        return "albumForm";
    }
//@RequestMapping(method = RequestMethod.POST
    @PostMapping("/addAlbumNow")

//   View that redirects to an absolute, context relative, or current request relative URL.
    public RedirectView addNewAlbum(@RequestParam String artist,
                                    @RequestParam String title,
                                    @RequestParam String imageURL) {
        Album newAlbum = new Album(title, artist, 0, 0, imageURL);
        albumRepository.save(newAlbum);
        return new RedirectView("/allAlbums");
    }
}