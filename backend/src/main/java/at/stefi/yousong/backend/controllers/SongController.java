package at.stefi.yousong.backend.controllers;

import java.util.List;

import at.stefi.yousong.backend.models.Song;
import at.stefi.yousong.backend.repositories.SongRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http://localhost:5173")
@RestController
class SongController {

    private final SongRepository repository;

    SongController(SongRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/songs")
    List<Song> all() {
        return repository.findAll();
    }


}