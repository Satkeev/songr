package com.Satkeev.songr;

    //is part of the Java Persistence API (JPA).
    import javax.persistence.*;

    @Entity
    public class Song {
        //Specifies the primary key of an entity
        @Id
        // specifies that a value will be automatically generated for that field
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String title;
        private int length;
        private int trackNumber;
        //Defines a single-valued association to another entity class that has many-to-one multiplicity
        @ManyToOne
        private Album album;

        public Song() {}
        //Create object Song
        public Song(String title, int length, int trackNumber, Album album) {
            this.setTitle(title);
            this.setLength(length);
            this.setTrackNumber(trackNumber);
            this.setAlbum(album);
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

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            if (length < 0)
                length = 0;
            this.length = length;
        }

        public int getTrackNumber() {
            return trackNumber;
        }

        public void setTrackNumber(int trackNumber) {
            if (trackNumber < 0)
                trackNumber = 0;
            this.trackNumber = trackNumber;
        }

        public Album getAlbum() {
            return album;
        }

        public void setAlbum(Album album) {
            this.album = album;
        }
    }

