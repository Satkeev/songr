package com.Satkeev.songr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AlbumController {


    private Object albumCollection;

    @GetMapping("/allAlbums")
    public String getAllAlbums(Model m) {
        m.addAttribute("albums", albumCollection);
        return "allAlbums";
    }

    @GetMapping("/addAlbum")
    public String getAddAlbum() {
        return "albumForm";
    }


}