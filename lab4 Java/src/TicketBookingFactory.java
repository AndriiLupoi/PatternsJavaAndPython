import java.time.LocalDateTime;

public interface TicketBookingFactory {
    Client createClient(String name, String number);
    Movie createMovie(String title, String genre, LocalDateTime appointmentTime);
    Seat createSeat(int seatNumber);
}
