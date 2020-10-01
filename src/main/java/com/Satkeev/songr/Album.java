package com.Satkeev.songr;

import javax.persistence.*;
import java.util.List;

@Entity
public class Album {
    @Id
    private long id;
    String title;
    String artist;
    int songCount;
    int length;
    String imageURL;


    public Album() {}

    public Album(String title, String artist, int songCount, int length, String imageURL) {
        this.setTitle(title);
        this.setArtist(artist);
        this.setLength(length);
        this.setImageURL(imageURL);
    }

    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.isEmpty())
            title = "No Title";
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        if (artist.isEmpty())
            artist = "Unknown Artist";
        this.artist = artist;
    }


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length < 0)
            length = 0;
        this.length = length;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        if (imageURL.isEmpty())
            imageURL = "https://cdn.onlinewebfonts.com/svg/img_148071.png";
        this.imageURL = imageURL;
    }


}
