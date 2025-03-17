package at.stefi.yousong.backend.repositories;

import at.stefi.yousong.backend.models.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ArtistRepository extends JpaRepository<Artist, Long>{

    Page<Artist> findAll(Pageable pageable);

    List<Artist> findByArtistNameIgnoreCaseContaining(String query);

    Artist findArtistByArtistName(String artistName);
}


