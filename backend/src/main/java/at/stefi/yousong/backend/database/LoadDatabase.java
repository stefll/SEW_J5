package at.stefi.yousong.backend.database;

import at.stefi.yousong.backend.models.Artist;
import at.stefi.yousong.backend.models.Song;
import at.stefi.yousong.backend.repositories.SongRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);


    @Bean
    CommandLineRunner initDatabase(SongRepository repository) {
        return args -> {
            log.info("Loading database with songs");
            repository.save(new Song("Wonderwall", new Artist("Oasis"), "Rock", 4.18));
            repository.save(new Song("Lose Yourself", new Artist( "Eminem"), "Hip-Hop", 5.26));
            repository.save(new Song("Bohemian Rhapsody", new Artist("Queen"), "Rock", 5.55));
            repository.save(new Song("Hotel California", new Artist("Eagles"), "Rock", 6.30));
            repository.save(new Song("Stairway to Heaven", new Artist("Led Zeppelin"), "Rock", 8.02));
            repository.save(new Song("Smells Like Teen Spirit", new Artist("Nirvana"), "Grunge", 5.01));
            repository.save(new Song("Imagine", new Artist("John Lennon"), "Pop", 3.03));
            repository.save(new Song("Shape of You", new Artist("Ed Sheeran"), "Pop", 3.54));
            repository.save(new Song("Blinding Lights", new Artist("The Weeknd"), "R&B", 3.22));
            repository.save(new Song("Enter Sandman", new Artist("Metallica"), "Metal", 5.32));
            repository.save(new Song("Uptown Funk", new Artist("Mark Ronson"), "Funk", 4.30));
            repository.save(new Song("Rolling in the Deep", new Artist("Adele"), "Pop", 3.48));
            repository.save(new Song("Hey Jude", new Artist("The Beatles"), "Rock", 7.08));
            repository.save(new Song("Back in Black", new Artist("AC/DC"), "Rock", 4.15));
            repository.save(new Song("Thriller", new Artist("Michael Jackson"), "Pop", 5.57));
            repository.save(new Song("Sweet Child O' Mine", new Artist("Guns N' Roses"), "Rock", 5.56));
            repository.save(new Song("Hallelujah", new Artist("Leonard Cohen"), "Folk", 6.53));
            repository.save(new Song("No Woman, No Cry", new Artist("Bob Marley"), "Reggae", 4.07));
            repository.save(new Song("Like a Rolling Stone", new Artist("Bob Dylan"), "Rock", 6.09));
        };
    }
}