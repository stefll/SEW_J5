package at.stefi.yousong.backend.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Artist {
    private @Id @GeneratedValue Long id;
    private String artistName;
    @OneToMany (mappedBy = "artist", cascade = CascadeType.REMOVE)
    private List<Song> songs;

    public Artist( String artistName) {
        this.artistName = artistName;
    }

    public Artist() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
