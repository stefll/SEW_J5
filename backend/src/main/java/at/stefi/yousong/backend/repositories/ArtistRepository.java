package at.stefi.yousong.backend.repositories;

import at.stefi.yousong.backend.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long>{

}
