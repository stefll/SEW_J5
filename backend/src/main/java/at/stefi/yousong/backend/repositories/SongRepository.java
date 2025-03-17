package at.stefi.yousong.backend.repositories;


import at.stefi.yousong.backend.models.Artist;
import at.stefi.yousong.backend.models.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins="*")
public interface SongRepository extends JpaRepository<Song, Long> {

   Page<Song> findByTitleIgnoreCaseContainingOrArtist_ArtistNameIgnoreCaseContaining(String title, String artistName, Pageable pageable);


}

