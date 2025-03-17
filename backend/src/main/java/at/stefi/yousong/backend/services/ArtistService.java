package at.stefi.yousong.backend.services;

import at.stefi.yousong.backend.models.Artist;
import at.stefi.yousong.backend.models.Song;
import at.stefi.yousong.backend.repositories.ArtistRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;


    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }
    public Page<Artist> getAllArtists(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return artistRepository.findAll(pageable);
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

    public void checkForArtist(Song song) {
        Artist existingartist = artistRepository.findArtistByArtistName(song.getArtist().getArtistName());
        if (existingartist != null) {
            song.setArtist(existingartist);
        }
        else {
            song.setArtist(artistRepository.save(song.getArtist()));
        }
    }
}
