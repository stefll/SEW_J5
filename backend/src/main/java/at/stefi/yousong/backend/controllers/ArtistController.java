package at.stefi.yousong.backend.controllers;

import at.stefi.yousong.backend.models.Artist;
import at.stefi.yousong.backend.repositories.ArtistRepository;
import at.stefi.yousong.backend.services.ArtistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ArtistController {

    private final ArtistService artistService;
    private final ArtistRepository artistRepository;


    ArtistController(ArtistService artistService, ArtistRepository artistRepository) {
        this.artistService = artistService;
        this.artistRepository = artistRepository;
    }

    @GetMapping("api/artists")
    public List<Artist> getAllArtists() {
        return artistService.getAllArtists();
    }

    @GetMapping("api/artists/{id}")
    public Artist one(@PathVariable long id) {
        return artistService.getArtistById(id);
    }

    @PutMapping("/api/artists")
    public Artist create(@RequestBody Artist artist) {
        return artistService.addArtist(artist);
    }

    @DeleteMapping("api/artists/{id}")
    public void deleteArtist(@PathVariable long id) {
        artistService.deleteArtistById(id);
    }
}

