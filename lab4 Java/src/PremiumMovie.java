import java.time.LocalDateTime;

public class PremiumMovie implements Movie {
    private String title;
    private String genre;
    private LocalDateTime appointmentTime;

    public PremiumMovie(String title, String genre, LocalDateTime appointmentTime) {
        this.title = title;
        this.genre = genre;
        this.appointmentTime = appointmentTime;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getGenre() {
        return genre;
    }

    @Override
    public LocalDateTime getShowTime() {
        return appointmentTime;
    }

    @Override
    public String toString() {
        return "PremiumMovie{" + "title='" + title + '\'' + ", genre='" + genre + '\'' + ", showTime=" + appointmentTime + '}';
    }
}
