package at.stefi.yousong.backend.assembler;

import at.stefi.yousong.backend.controllers.SongController;
import at.stefi.yousong.backend.models.Song;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SongModelAssembler implements RepresentationModelAssembler<Song, EntityModel<Song>> {
    @Override
    public EntityModel<Song> toModel(Song song) {
        return EntityModel.of(song, linkTo(methodOn(SongController.class).one(song.getId())).withSelfRel(), linkTo(methodOn(SongController.class).all()).withRel("songs"));
    }
}
