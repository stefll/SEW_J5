package at.stefi.yousong.backend.repositories;


import at.stefi.yousong.backend.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:51723")
public interface SongRepository extends JpaRepository<Song, Long> {

}
