import java.time.LocalDateTime;

public class Movie {
    private String title;
    private String genre;
    private LocalDateTime showTime;

    public Movie(String title, String genre, LocalDateTime showTime) {
        this.title = title;
        this.genre = genre;
        this.showTime = showTime;
    }

    @Override
    public String toString() {
        return "Movie{" + "title='" + title + '\'' + ", genre='" + genre + '\'' + ", showTime=" + showTime + '}';
    }
}
