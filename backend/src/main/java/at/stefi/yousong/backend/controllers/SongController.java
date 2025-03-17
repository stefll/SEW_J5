package at.stefi.yousong.backend.controllers;

import at.stefi.yousong.backend.models.Artist;
import at.stefi.yousong.backend.models.Song;
import at.stefi.yousong.backend.repositories.SongRepository;
import at.stefi.yousong.backend.services.ArtistService;
import at.stefi.yousong.backend.services.SongService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class SongController {

    private final SongRepository repository;
    private final SongService songService;
    private final ArtistService artistService;

    SongController(SongRepository repository, SongService songService, ArtistService artistService) {
        this.repository = repository;
        this.songService = songService;
        this.artistService = artistService;
    }

    @GetMapping("/api/songs")
    public Page<Song> all(@RequestParam("page") int page,@RequestParam("size") int size) {
        return songService.getAllSongs(page, size);
    }

    @GetMapping("/api/songs/{id}")
    public Song one(@PathVariable("id") long id) {
        return songService.getSongById(id);
    }

    @PutMapping("/api/songs")
    public Song create(@RequestBody Song song) {
        artistService.checkForArtist(song);
        return songService.addSong(song);
    }

    @DeleteMapping("/api/songs/{id}")
    public void delete(@PathVariable("id") long id) {
        songService.deleteSong(id);
    }

    @GetMapping("/api/songs/search")
    public Page<Song> search(@RequestParam String query, @RequestParam("page") int page, @RequestParam("size") int size) {
        return songService.searchSong(query, page, size);
    }
}