package at.stefi.yousong.backend.services;

import at.stefi.yousong.backend.assembler.SongModelAssembler;
import at.stefi.yousong.backend.controllers.SongController;
import at.stefi.yousong.backend.models.Song;
import at.stefi.yousong.backend.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Service
public class SongService {
    @Autowired
    SongRepository songRepository;

    private final SongModelAssembler assembler;
    @Autowired
    private SongModelAssembler songModelAssembler;

    SongService(SongRepository repository, SongModelAssembler assembler) {
        this.songRepository = repository;
        this.assembler = assembler;
    }
    public CollectionModel<EntityModel<Song>> getAllSongs() {
        List<EntityModel<Song>> songs = songRepository.findAll().stream().map(assembler::toModel).toList();
        return CollectionModel.of(songs, linkTo(methodOn(SongController.class).all()).withSelfRel());
    }

    public EntityModel<Song> getSongById(Long id) {
        Song song = songRepository.findById(id).orElseThrow();
        return assembler.toModel(song);
    }
    public EntityModel<Song> addSong(Song song) {
       return songModelAssembler.toModel(songRepository.save(song));

    }

    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }
}

