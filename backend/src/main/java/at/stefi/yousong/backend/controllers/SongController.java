package at.stefi.yousong.backend.controllers;

import at.stefi.yousong.backend.models.Song;
import at.stefi.yousong.backend.repositories.SongRepository;
import at.stefi.yousong.backend.services.SongService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class SongController {

    private final SongRepository repository;
    private final SongService songService;

    SongController(SongRepository repository, SongService songService) {
        this.repository = repository;
        this.songService = songService;
    }

    @GetMapping("/api/songs")
    public CollectionModel<EntityModel<Song>> all() {
        return songService.getAllSongs();
    }

    @GetMapping("/api/songs/{id}")
    public EntityModel<Song> one(@PathVariable("id") long id) {
        return songService.getSongById(id);
    }

    @PutMapping("/api/songs")
    public EntityModel<Song> create(@RequestBody Song song) {
        return songService.addSong(song);
    }

    @DeleteMapping("/api/songs/{id}")
    public void delete(@PathVariable("id") long id) {
        songService.deleteSong(id);
    }

    @GetMapping("/api/songs/search")
    public List<EntityModel<Song>> search(@RequestParam String query) {
        return songService.searchSong(query);
    }
}