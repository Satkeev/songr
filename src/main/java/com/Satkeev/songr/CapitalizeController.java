package com.Satkeev.songr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
    public class CapitalizeController {

        //takes a string from the path and capitalizes it, then returns that to render on the page
        @GetMapping("/capitalize/{word}")
        public static String capitalize(@PathVariable String word) {
            return word.toUpperCase();
        }
}
