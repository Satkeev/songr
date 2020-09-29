package com.Satkeev.songr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SongController {
    @Autowired
    private SongRepository songRepo;

    @RequestMapping(value = "/songs", method = RequestMethod.GET)
    public String index(Model m) {
        m.addAttribute("songs", songRepo.findAll());
        return "songs";
    }
}
