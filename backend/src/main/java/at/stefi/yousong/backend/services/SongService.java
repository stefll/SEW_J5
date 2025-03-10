package at.stefi.yousong.backend.services;

import at.stefi.yousong.backend.models.Song;
import at.stefi.yousong.backend.repositories.SongRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@Service
public class SongService {
    private final SongRepository songRepository;


    SongService(SongRepository repository) {
        this.songRepository = repository;
    }
    public Page<Song> getAllSongs(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return songRepository.findAll(pageable);
    }

    public Song getSongById(Long id) {
        Song song = songRepository.findById(id).orElseThrow();
        return song;
    }
    public Song addSong(Song song) {
       return songRepository.save(song);

    }

    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }

    public Page<Song> searchSong(String query, int page, int size) {
        Pageable pageable = PageRequest.of(page, size );
        return songRepository.findByTitleIgnoreCaseContainingOrArtist_ArtistNameIgnoreCaseContaining(query,query,pageable);
    }

}

