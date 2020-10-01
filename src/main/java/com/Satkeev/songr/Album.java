package com.Satkeev.songr;

import javax.persistence.*;
import java.util.List;

@Entity
public class Album {
    // Specifies the primary key of an entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    String title;
    String artist;
    int songCount;
    int length;
    String imageURL;
    // specifies that a value will be automatically generated for that field
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)

    List<Song> songs;

    public Album() {}
    //Create object Album
    public Album(String title, String artist, int songCount, int length, String imageURL) {
        this.setTitle(title);
        this.setArtist(artist);
        this.setSongCount(songCount);
        this.setLength(length);
        this.setImageURL(imageURL);
    }
    //The thread ID is a positive long number generated when this thread was created.
    public long getId() {
        return this.id;
    }
    //method is creating the string
    public String getTitle() {
        return title;
    }
    // As the return type is a String value
    public void setTitle(String title) {
        if (title.isEmpty())
            title = "No Title";
        this.title = title;
    }
    // As the return type is a String value
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        if (artist.isEmpty())
            artist = "Unknown Artist";
        this.artist = artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        if (songCount < 0)
            songCount = 0;
        this.songCount = songCount;
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

    public List<Song> getSongs() {
        return this.songs;
    }
}