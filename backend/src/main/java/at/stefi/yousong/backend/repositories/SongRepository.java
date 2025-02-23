package at.stefi.yousong.backend.repositories;


import at.stefi.yousong.backend.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins="*")
public interface SongRepository extends JpaRepository<Song, Long> {

   List<Song> findByTitleIgnoreCaseContainingOrArtistIgnoreCaseContaining(String title, String artist);
}

