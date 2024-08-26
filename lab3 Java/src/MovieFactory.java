import java.time.LocalDateTime;

public class MovieFactory {
    public Movie createMovie(String title, String genre, LocalDateTime showTime) {
        return new Movie(title, genre, showTime);
    }
}
