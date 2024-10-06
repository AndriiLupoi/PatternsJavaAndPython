import java.time.LocalDateTime;

public class Movie {
    private String title;
    private String genre;
    private LocalDateTime appointmentTime;

    public Movie(String title, String genre, LocalDateTime appointmentTime) {
        this.title = title;
        this.genre = genre;
        this.appointmentTime = appointmentTime;
    }

    @Override
    public String toString() {
        return "Movie{" + "title='" + title + '\'' + ", genre='" + genre + '\'' + ", showTime=" + appointmentTime + '}';
    }
}


