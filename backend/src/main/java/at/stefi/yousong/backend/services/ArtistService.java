package at.stefi.yousong.backend.services;

import at.stefi.yousong.backend.models.Artist;
import at.stefi.yousong.backend.repositories.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;


    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }
    public Artist getArtistById(long id) {
        return artistRepository.findById(id).orElseThrow();
    }
    public Artist addArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public void deleteArtistById(long id) {
        artistRepository.deleteById(id);
    }
}
