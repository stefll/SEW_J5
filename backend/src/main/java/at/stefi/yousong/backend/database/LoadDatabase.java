package at.stefi.yousong.backend.database;

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
            repository.save(new Song("Wonderwall", "Oasis", "Rock", 4.18));
            repository.save(new Song("Lose Yourself", "Eminem", "Hip-Hop", 5.26));
            repository.save(new Song("Bohemian Rhapsody", "Queen", "Rock", 5.55));
            repository.save(new Song("Hotel California", "Eagles", "Rock", 6.30));
            repository.save(new Song("Stairway to Heaven", "Led Zeppelin", "Rock", 8.02));
            repository.save(new Song("Smells Like Teen Spirit", "Nirvana", "Grunge", 5.01));
            repository.save(new Song("Imagine", "John Lennon", "Pop", 3.03));
            repository.save(new Song("Shape of You", "Ed Sheeran", "Pop", 3.54));
            repository.save(new Song("Blinding Lights", "The Weeknd", "R&B", 3.22));
            repository.save(new Song("Enter Sandman", "Metallica", "Metal", 5.32));
            repository.save(new Song("Uptown Funk", "Mark Ronson ft. Bruno Mars", "Funk", 4.30));
            repository.save(new Song("Rolling in the Deep", "Adele", "Pop", 3.48));
            repository.save(new Song("Hey Jude", "The Beatles", "Rock", 7.08));
            repository.save(new Song("Billie Jean", "Michael Jackson", "Pop", 4.54));
            repository.save(new Song("Back in Black", "AC/DC", "Rock", 4.15));
            repository.save(new Song("Thriller", "Michael Jackson", "Pop", 5.57));
            repository.save(new Song("Sweet Child O' Mine", "Guns N' Roses", "Rock", 5.56));
            repository.save(new Song("Hallelujah", "Leonard Cohen", "Folk", 6.53));
            repository.save(new Song("No Woman, No Cry", "Bob Marley", "Reggae", 4.07));
            repository.save(new Song("Like a Rolling Stone", "Bob Dylan", "Rock", 6.09));
        };
    }
}