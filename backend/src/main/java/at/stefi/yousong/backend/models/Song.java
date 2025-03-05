package at.stefi.yousong.backend.models;

import jakarta.persistence.*;

@Entity
public class Song {

    private @Id @GeneratedValue Long id;
    private String title;
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "artist_id")
    private Artist artist;
    private String genre;
    private double length;

    public Song(String title, Artist artist, String genre, double length) {

        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.length = length;

    }

    public Song() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}